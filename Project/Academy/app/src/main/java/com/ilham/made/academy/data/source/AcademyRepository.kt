package com.ilham.made.academy.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.ilham.made.academy.data.source.local.LocalDataSource
import com.ilham.made.academy.data.source.local.entity.CourseEntity
import com.ilham.made.academy.data.source.local.entity.CourseWithModule
import com.ilham.made.academy.data.source.local.entity.ModuleEntity
import com.ilham.made.academy.data.source.remote.ApiResponse
import com.ilham.made.academy.data.source.remote.RemoteDataSource
import com.ilham.made.academy.data.source.remote.response.ContentResponse
import com.ilham.made.academy.data.source.remote.response.CourseResponse
import com.ilham.made.academy.data.source.remote.response.ModuleResponse
import com.ilham.made.academy.utils.AppExecutors
import com.ilham.made.academy.vo.Resource

class AcademyRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : AcademyDataSource {

    companion object {
        @Volatile
        private var instance: AcademyRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): AcademyRepository =
            instance ?: synchronized(this) {
                instance ?: AcademyRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllCourses(): LiveData<Resource<PagedList<CourseEntity>>> {
        return object :
            NetworkBoundResource<PagedList<CourseEntity>, List<CourseResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<CourseEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllCourses(), config).build()
            }

            override fun shouldFetch(data: PagedList<CourseEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<CourseResponse>>> =
                remoteDataSource.getAllCourses()

            public override fun saveCallResult(courseResponses: List<CourseResponse>) {
                val courseList = ArrayList<CourseEntity>()
                for (response in courseResponses) {
                    val course = CourseEntity(
                        response.id,
                        response.title,
                        response.description,
                        response.date,
                        false,
                        response.imagePath
                    )
                    courseList.add(course)
                }

                localDataSource.insertCourses(courseList)
            }
        }.asLiveData()
    }

    override fun getBookmarkedCourses(): LiveData<PagedList<CourseEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getBookmarkedCourses(), config).build()
    }

    override fun getCourseWithModules(courseId: String): LiveData<Resource<CourseWithModule>> {
        return object : NetworkBoundResource<CourseWithModule, List<ModuleResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<CourseWithModule> =
                localDataSource.getCourseWithModules(courseId)

            override fun shouldFetch(courseWithModule: CourseWithModule?): Boolean =
                courseWithModule?.mModules == null || courseWithModule.mModules.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ModuleResponse>>> =
                remoteDataSource.getModules(courseId)

            override fun saveCallResult(moduleResponses: List<ModuleResponse>) {
                val moduleList = ArrayList<ModuleEntity>()
                for (response in moduleResponses) {
                    val course = ModuleEntity(
                        response.moduleId,
                        response.courseId,
                        response.title,
                        response.position,
                        false
                    )
                    moduleList.add(course)
                }
                localDataSource.insertModules(moduleList)
            }
        }.asLiveData()
    }

    override fun getAllModulesByCourse(courseId: String): LiveData<Resource<List<ModuleEntity>>> {
        return object :
            NetworkBoundResource<List<ModuleEntity>, List<ModuleResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<ModuleEntity>> =
                localDataSource.getAllModulesByCourse(courseId)

            override fun shouldFetch(modules: List<ModuleEntity>?): Boolean =
                modules == null || modules.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ModuleResponse>>> =
                remoteDataSource.getModules(courseId)

            override fun saveCallResult(moduleResponses: List<ModuleResponse>) {
                val moduleList = ArrayList<ModuleEntity>()
                for (response in moduleResponses) {
                    val course = ModuleEntity(
                        response.moduleId,
                        response.courseId,
                        response.title,
                        response.position,
                        false
                    )

                    moduleList.add(course)
                }

                localDataSource.insertModules(moduleList)
            }
        }.asLiveData()
    }


    override fun getContent(moduleId: String): LiveData<Resource<ModuleEntity>> {
        return object : NetworkBoundResource<ModuleEntity, ContentResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<ModuleEntity> =
                localDataSource.getModuleWithContent(moduleId)

            override fun shouldFetch(moduleEntity: ModuleEntity?): Boolean =
                moduleEntity?.contentEntity == null

            override fun createCall(): LiveData<ApiResponse<ContentResponse>> =
                remoteDataSource.getContent(moduleId)

            override fun saveCallResult(contentResponse: ContentResponse) =
                localDataSource.updateContent(contentResponse.content.toString(), moduleId)
        }.asLiveData()
    }

    override fun setCourseBookmark(course: CourseEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setCourseBookmark(course, state) }

    override fun setReadModule(module: ModuleEntity) =
        appExecutors.diskIO().execute { localDataSource.setReadModule(module) }

}
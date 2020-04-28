package com.ilham.made.academy.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.ilham.made.academy.LiveDataTestUtil
import com.ilham.made.academy.PagedListUtil
import com.ilham.made.academy.data.source.local.LocalDataSource
import com.ilham.made.academy.data.source.local.entity.CourseEntity
import com.ilham.made.academy.data.source.local.entity.CourseWithModule
import com.ilham.made.academy.data.source.local.entity.ModuleEntity
import com.ilham.made.academy.data.source.remote.RemoteDataSource
import com.ilham.made.academy.utils.AppExecutors
import com.ilham.made.academy.utils.DataDummy
import com.ilham.made.academy.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class AcademyRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val academyRepository = FakeAcademyRepository(remote, local, appExecutors)

    private val courseResponses = DataDummy.generateRemoteDummyCourses()
    private val courseId = courseResponses[0].id
    private val moduleResponses = DataDummy.generateRemoteDummyModules(courseId)
    private val moduleId = moduleResponses[0].moduleId
    private val content = DataDummy.generateRemoteDummyContent(moduleId)

    @Test
    fun getAllCourses() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, CourseEntity>
        `when`(local.getAllCourses()).thenReturn(dataSourceFactory)
        academyRepository.getAllCourses()

        val courseEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyCourses()))
        verify(local).getAllCourses()
        assertNotNull(courseEntities.data)
        assertEquals(courseResponses.size.toLong(), courseEntities.data?.size?.toLong())
    }

    @Test
    fun getBookmarkedCourses() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, CourseEntity>
        `when`(local.getBookmarkedCourses()).thenReturn(dataSourceFactory)
        academyRepository.getBookmarkedCourses()
        val courseEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyCourses()))
        verify(local).getBookmarkedCourses()
        assertNotNull(courseEntities)
        assertEquals(courseResponses.size.toLong(), courseEntities.data?.size?.toLong())
    }

    @Test
    fun getAllModulesByCourse() {
        val dummyModules = MutableLiveData<List<ModuleEntity>>()
        dummyModules.value = DataDummy.generateDummyModules(courseId)
        `when`(local.getAllModulesByCourse(courseId)).thenReturn(dummyModules)

        val courseEntities = LiveDataTestUtil.getValue(academyRepository.getAllModulesByCourse(courseId))
        verify(local).getAllModulesByCourse(courseId)
        assertNotNull(courseEntities.data)
        assertEquals(moduleResponses.size.toLong(), courseEntities.data?.size?.toLong())
    }

    @Test
    fun getContent() {
        val dummyEntity = MutableLiveData<ModuleEntity>()
        dummyEntity.value = DataDummy.generateDummyModuleWithContent(moduleId)
        `when`(local.getModuleWithContent(courseId)).thenReturn(dummyEntity)

        val courseEntitiesContent = LiveDataTestUtil.getValue(academyRepository.getContent(courseId))
        verify(local).getModuleWithContent(courseId)
        assertNotNull(courseEntitiesContent)
        assertNotNull(courseEntitiesContent.data?.contentEntity)
        assertNotNull(courseEntitiesContent.data?.contentEntity?.content)
        assertEquals(content.content, courseEntitiesContent.data?.contentEntity?.content)
    }


    @Test
    fun getCourseWithModules() {
        val dummyEntity = MutableLiveData<CourseWithModule>()
        dummyEntity.value = DataDummy.generateDummyCourseWithModules(DataDummy.generateDummyCourses()[0], false)
        `when`(local.getCourseWithModules(courseId)).thenReturn(dummyEntity)
        val courseEntities = LiveDataTestUtil.getValue(academyRepository.getCourseWithModules(courseId))
        verify(local).getCourseWithModules(courseId)
        assertNotNull(courseEntities.data)
        assertNotNull(courseEntities.data?.mCourse?.title)
        assertEquals(courseResponses[0].title, courseEntities.data?.mCourse?.title)
    }
}
package com.ilham.made.academy.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.ilham.made.academy.data.source.local.entity.CourseEntity
import com.ilham.made.academy.data.source.local.entity.CourseWithModule
import com.ilham.made.academy.data.source.local.entity.ModuleEntity
import com.ilham.made.academy.data.source.local.room.AcademyDao

class LocalDataSource private constructor(private val mAcademyDao: AcademyDao) {
 
    companion object {
        private var INSTANCE: LocalDataSource? = null
 
        fun getInstance(academyDao: AcademyDao): LocalDataSource =
                INSTANCE ?: LocalDataSource(academyDao)
    }
 
    fun getAllCourses(): DataSource.Factory<Int, CourseEntity> = mAcademyDao.getCourses()
 
    fun getBookmarkedCourses(): DataSource.Factory<Int, CourseEntity> = mAcademyDao.getBookmarkedCourse()
 
    fun getCourseWithModules(courseId: String): LiveData<CourseWithModule> =
            mAcademyDao.getCourseWithModuleById(courseId)
 
    fun getAllModulesByCourse(courseId: String): LiveData<List<ModuleEntity>> =
            mAcademyDao.getModulesByCourseId(courseId)
 
    fun insertCourses(courses: List<CourseEntity>) = mAcademyDao.insertCourses(courses)
 
    fun insertModules(modules: List<ModuleEntity>) = mAcademyDao.insertModules(modules)
 
    fun setCourseBookmark(course: CourseEntity, newState: Boolean) {
        course.bookmarked = newState
        mAcademyDao.updateCourse(course)
    }
 
    fun getModuleWithContent(moduleId: String): LiveData<ModuleEntity> =
            mAcademyDao.getModuleById(moduleId)
 
    fun updateContent(content: String, moduleId: String) {
        mAcademyDao.updateModuleByContent(content, moduleId)
    }
 
    fun setReadModule(module: ModuleEntity) {
        module.read = true
        mAcademyDao.updateModule(module)
    }
}
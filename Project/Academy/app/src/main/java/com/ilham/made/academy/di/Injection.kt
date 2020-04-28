package com.ilham.made.academy.di

import android.content.Context
import com.ilham.made.academy.data.source.AcademyRepository
import com.ilham.made.academy.data.source.local.LocalDataSource
import com.ilham.made.academy.data.source.local.room.AcademyDatabase
import com.ilham.made.academy.data.source.remote.RemoteDataSource
import com.ilham.made.academy.utils.AppExecutors
import com.ilham.made.academy.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): AcademyRepository {

        val database = AcademyDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.academyDao())
        val appExecutors = AppExecutors()

        return AcademyRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}
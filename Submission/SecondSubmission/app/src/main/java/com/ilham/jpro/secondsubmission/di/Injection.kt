package com.ilham.jpro.secondsubmission.di

import com.ilham.jpro.secondsubmission.data.source.CatalogRepository
import com.ilham.jpro.secondsubmission.data.source.remote.RemoteDataSource

object Injection {

    fun provideCatalogRepository(): CatalogRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return CatalogRepository.getInstance(remoteDataSource)
    }
}
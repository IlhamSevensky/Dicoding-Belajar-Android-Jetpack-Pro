package com.ilham.jpro.firstsubmission.ui.home

import androidx.lifecycle.ViewModel
import com.ilham.jpro.firstsubmission.model.DataModel
import com.ilham.jpro.firstsubmission.utils.DataDummy

class HomeViewModel : ViewModel() {

    fun getListMovie(): List<DataModel> = DataDummy.generateDataMovieDummy()

    fun getListTvShow(): List<DataModel> = DataDummy.generateDataTvShowDummy()

}
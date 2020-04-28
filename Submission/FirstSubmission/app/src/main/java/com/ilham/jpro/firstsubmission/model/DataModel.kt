package com.ilham.jpro.firstsubmission.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class DataModel(
    var id: String,
    var name: String,
    var desc: String,
    var poster: String,
    var img_preview: String
) : Parcelable
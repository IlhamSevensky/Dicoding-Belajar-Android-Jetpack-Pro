package com.ilham.jpro.lastsubmission.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tb_favorite_movie")
@Parcelize
data class MovieEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: Int = 0,

    @ColumnInfo(name = "movieName")
    var name: String? = null,

    @ColumnInfo(name = "movieDesc")
    var desc: String? = null,

    @ColumnInfo(name = "moviePoster")
    var poster: String? = null,

    @ColumnInfo(name = "movieImgPreview")
    var imgPreview: String? = null,

    @NonNull
    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
): Parcelable
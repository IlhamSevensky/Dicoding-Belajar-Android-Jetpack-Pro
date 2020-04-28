package com.ilham.jpro.lastsubmission.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tb_favorite_tvshow")
@Parcelize
data class TvShowEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @NonNull
    @ColumnInfo(name = "tvShowId")
    var tvShowId: Int = 0,

    @ColumnInfo(name = "tvShowName")
    var name: String? = null,

    @ColumnInfo(name = "tvShowDesc")
    var desc: String? = null,

    @ColumnInfo(name = "tvShowPoster")
    var poster: String? = null,

    @ColumnInfo(name = "tvShowImgPreview")
    var imgPreview: String? = null,

    @NonNull
    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
): Parcelable
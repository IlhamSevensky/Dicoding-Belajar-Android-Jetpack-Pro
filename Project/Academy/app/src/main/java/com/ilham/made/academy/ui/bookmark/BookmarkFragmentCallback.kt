package com.ilham.made.academy.ui.bookmark

import com.ilham.made.academy.data.source.local.entity.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}

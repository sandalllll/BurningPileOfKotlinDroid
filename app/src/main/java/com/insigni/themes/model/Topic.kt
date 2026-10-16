package com.insigni.themes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(@StringRes val topicNameId: Int, val themesCount: Int, @DrawableRes val imageResourceId: Int) {
}
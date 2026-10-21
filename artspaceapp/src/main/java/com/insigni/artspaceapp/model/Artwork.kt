package com.insigni.artspaceapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Artwork(@DrawableRes val paintingId: Int,
              @StringRes val paintingNameId: Int,
              @StringRes val authorId: Int,
              val year: Int) {

}
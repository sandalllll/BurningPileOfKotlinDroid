package com.insigni.artspaceapp2.model

import androidx.annotation.StringRes
import androidx.annotation.DrawableRes

class Artwork(@DrawableRes val paintingId: Int,
              @StringRes val paintingNameId: Int,
              @StringRes val authorId: Int,
              val year: Int
) {
}
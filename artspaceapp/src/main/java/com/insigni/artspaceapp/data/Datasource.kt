package com.insigni.artspaceapp.data

import com.insigni.artspaceapp.R
import com.insigni.artspaceapp.model.Artwork

class Datasource() {
    fun loadArtwork(i: Int): List<Artwork> {
        return listOf<Artwork>(
            Artwork(R.drawable.the_tower_of_babel, R.string.the_tower_of_babel, R.string.pieter_bruegel_the_elder, 1563),
            Artwork(R.drawable.the_harvesters, R.string.the_harvesters, R.string.pieter_bruegel_the_elder, 1565),
            Artwork(R.drawable.the_hay_wagon, R.string.the_hay_wagon, R.string.hieronymus_bosch, 1516),
            Artwork(R.drawable.death_and_the_miser, R.string.death_and_the_miser, R.string.hieronymus_bosch, 1500)
        )
    }
}

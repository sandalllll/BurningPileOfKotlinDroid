package com.insigni.mycity.data

import com.insigni.mycity.model.PlaceCategory
import com.insigni.mycity.R
import kotlin.collections.listOf
import com.insigni.mycity.model.Place

    val placeCategories: List<PlaceCategory> = listOf<PlaceCategory>(
        PlaceCategory(0, R.string.cat_restaurants, R.drawable.cat_restaurants),
        PlaceCategory(1, R.string.cat_parks, R.drawable.cat_parks),
        PlaceCategory(2, R.string.cat_coffee_shops, R.drawable.cat_coffee_shops),
        PlaceCategory(3, R.string.cat_cinemas, R.drawable.cat_cinemas),
        PlaceCategory(4, R.string.cat_shopping_centers, R.drawable.cat_shopping_centers),
    )
    val places = listOf<List<Place>>(
        listOf<Place>(
            Place(R.string.rst_hrt, R.string.rst_hrt_desc, R.drawable.rst_hrt),
            Place(R.string.rst_beb, R.string.rst_beb_desc, R.drawable.rst_beb),
            Place(R.string.rst_kaz, R.string.rst_kaz_desc, R.drawable.rst_kaz),
        ),
        listOf<Place>(
            Place(R.string.par_juj,   R.string.par_juj_desc,   R.drawable.par_juj),
            Place(R.string.par_antsh, R.string.par_antsh_desc, R.drawable.par_antsh),
            Place(R.string.par_kuz,   R.string.par_kuz_desc,   R.drawable.par_kuz),
        ),
        listOf<Place>(
            Place(R.string.cof_rst, R.string.cof_rst_desc, R.drawable.cof_rst),
            Place(R.string.cof_sdj, R.string.cof_sdj_desc, R.drawable.cof_sdj),
            Place(R.string.cof_mus, R.string.cof_mus_desc, R.drawable.cof_mus),
        ),
        listOf<Place>(
            Place(R.string.cin_ksm, R.string.cin_ksm_desc, R.drawable.cin_ksm),
            Place(R.string.cin_ubi, R.string.cin_ubi_desc, R.drawable.cin_ubi),
            Place(R.string.cin_kuz, R.string.cin_kuz_desc, R.drawable.cin_kuz),
        ),
        listOf<Place>(
            Place(R.string.tz_merk, R.string.tz_merk_desc, R.drawable.tz_merk),
            Place(R.string.tz_7,    R.string.tz_7_desc,    R.drawable.tz_7),
            Place(R.string.tz_many, R.string.tz_many_desc, R.drawable.tz_many),
        ),
    )
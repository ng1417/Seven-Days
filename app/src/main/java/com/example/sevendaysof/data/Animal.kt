package com.example.sevendaysof.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.sevendaysof.R
data class Animal(
    @StringRes val nameResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val tipResourceId: Int,
    @StringRes val descriptionId: Int,
)

object AnimalData {
    val animals = listOf(
        Animal(R.string.cat, R.drawable.cat, R.string.cat_tip, R.string.cat_image),
        Animal(R.string.guineapig, R.drawable.guineapig, R.string.guineapig_tip, R.string.guineapig_image),
        Animal(R.string.hedgehog, R.drawable.hedgehog, R.string.hedgehog_tip, R.string.hedgehog_image),
        Animal(R.string.owl, R.drawable.owl, R.string.owl_tip, R.string.owl_image),
        Animal(R.string.pug, R.drawable.pug, R.string.pug_tip, R.string.pug_image),
        Animal(R.string.rabbit, R.drawable.rabbit, R.string.rabbit_tip, R.string.rabbit_image),
        Animal(R.string.red_panda, R.drawable.red_panda, R.string.red_panda_tip, R.string.red_panda_image),
        Animal(R.string.squirrel, R.drawable.squirrel, R.string.squirrel_tip, R.string.squirrel_image)
    )
}



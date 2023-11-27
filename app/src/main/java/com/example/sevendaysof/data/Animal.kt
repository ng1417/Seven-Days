package com.example.sevendaysof.data

import com.example.sevendaysof.R
data class Animal(
    val nameResourceId: Int,
    val imageResourceId: Int,
    val tipResourceId: Int
)

object AnimalData {
    val animals = listOf(
        Animal(R.string.cat, R.drawable.cat, R.string.cat_tip),
        Animal(R.string.guineapig, R.drawable.guineapig, R.string.guineapig_tip),
        Animal(R.string.hedgehog, R.drawable.hedgehog, R.string.hedgehog_tip),
        Animal(R.string.owl, R.drawable.owl, R.string.owl_tip),
        Animal(R.string.pug, R.drawable.pug, R.string.pug_tip),
        Animal(R.string.rabbit, R.drawable.rabbit, R.string.rabbit_tip),
        Animal(R.string.red_panda, R.drawable.red_panda, R.string.red_panda_tip),
        Animal(R.string.squirrel, R.drawable.squirrel, R.string.squirrel_tip)
    )
}



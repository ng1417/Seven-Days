package com.example.sevendaysof.data

import com.example.sevendaysof.R

data class Animal(
    val name: Int,
    val imageResourceId: Int,
    val descriptionResourceId: Int
)

object AnimalData {
    val animals = listOf(
        Animal(R.string.cat, R.drawable.cat, R.string.cat_description),
       Animal(R.string.guineapig,R.drawable.guineapig, R.string.guineapig_description),
       Animal(R.string.hedgehog, R.drawable.hedgehog, R.string.hedgehog_description),
       Animal(R.string.owl, R.drawable.owl, R.string.owl_description),
       Animal(R.string.pug, R.drawable.pug, R.string.pug_description),
        Animal(R.string.rabbit, R.drawable.rabbit, R.string.rabbit_description),
        Animal(R.string.red_panda, R.drawable.red_panda, R.string.red_panda_description),
        Animal(R.string.squirrel, R.drawable.squirrel, R.string.squirrel_description)
    )
}


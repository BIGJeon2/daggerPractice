package com.jeon.daggerpractice

import com.jeon.daggerpractice.module.Ingredient

data class BeverageInfo(
    val name: String,
    val ingredient: List<Ingredient>,
    val price: Int,
    val enableCustomIngredient: List<Ingredient>
)

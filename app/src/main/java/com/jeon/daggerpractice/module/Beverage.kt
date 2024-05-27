package com.jeon.daggerpractice.module

data class Beverage(
    val name: String,
    val ingredient: List<Ingredient>,
    val price: Int,
    val enableCustomIngredient: List<Ingredient>
)
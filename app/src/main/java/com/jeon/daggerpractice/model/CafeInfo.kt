package com.jeon.daggerpractice.model

import com.jeon.daggerpractice.api.Cafe
import com.jeon.daggerpractice.impl.StarCoffee

class CafeInfo {
    val cafeInfo : Cafe = StarCoffee()

    fun showCompanyInfo(){
        cafeInfo.showCompanyInf()
    }

    fun showMenu(){
        cafeInfo.showMenu()
    }

}
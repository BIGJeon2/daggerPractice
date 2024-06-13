package com.jeon.daggerpractice.impl

import android.util.Log
import com.jeon.daggerpractice.api.Cafe
import javax.inject.Inject

class StarCoffee @Inject constructor() : Cafe {

    override fun showCompanyInfo() {
        Log.d("StarCoffee", "CompanyInfo : 이곳은 별다방 카페 입니다.")
    }

    override fun showMenu() {
        Log.d("StarCoffee", "MenuInfo : 커피, 우유, 따듯한 차.")
    }

}
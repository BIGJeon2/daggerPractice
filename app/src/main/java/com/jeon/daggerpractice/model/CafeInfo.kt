package com.jeon.daggerpractice.model

import com.jeon.daggerpractice.api.Cafe
import javax.inject.Inject

class CafeInfo {
    @Inject
    lateinit var companyInfo : Cafe

    fun showCompanyInfo(){
        companyInfo.showCompanyInf()
    }

    fun showMenu(){
        companyInfo.showMenu()
    }

}
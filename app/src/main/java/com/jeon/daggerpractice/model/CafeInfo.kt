package com.jeon.daggerpractice.model

import com.jeon.daggerpractice.api.Cafe
import javax.inject.Inject

interface CafeInfo{
    fun showCompanyInfo()
    fun showMenu()
}
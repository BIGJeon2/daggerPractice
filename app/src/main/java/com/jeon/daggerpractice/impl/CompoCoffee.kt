package com.jeon.daggerpractice.impl

import android.util.Log
import com.jeon.daggerpractice.api.Cafe

class CompoCoffee : Cafe {

    override fun showCompanyInf() {
        Log.d("CompoCoffee", "CompanyInfo : 이곳은 컴포 카페 입니다.")
    }

    override fun showMenu() {
        Log.d("CompoCoffee", "MenuInfo : 밀크 티, 샌드위치, 프로틴.")
    }

}
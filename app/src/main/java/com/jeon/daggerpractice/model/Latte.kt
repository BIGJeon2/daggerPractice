package com.jeon.daggerpractice.model

import android.content.Context
import android.widget.Toast
import com.jeon.daggerpractice.Beverage
import com.jeon.daggerpractice.BeverageInfo
import javax.inject.Inject

class Latte(context: Context, override val beverageInfo: BeverageInfo) : Beverage {
    private val mContext = context
    @Inject
    lateinit var company: String

    override fun showInfo() {
        Toast.makeText(mContext, "This is latte", Toast.LENGTH_SHORT).show()
    }
}



package com.jeon.daggerpractice.model

import android.content.Context
import android.widget.Toast
import com.jeon.daggerpractice.Beverage
import com.jeon.daggerpractice.BeverageInfo

class Coffee(context: Context, override val beverageInfo: BeverageInfo) : Beverage {
    private val mContext = context
    override fun showInfo() {
        Toast.makeText(mContext, "This is Coffee", Toast.LENGTH_SHORT).show()
    }
}
package com.jeon.daggerpractice.module

import com.jeon.daggerpractice.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

@Module
@InstallIn(MainActivity::class)
object CompanyModule {
    @Provides
    fun getCompanyName() : String{
        return "Mega"
    }
}
package com.jeon.daggerpractice.obj

import com.jeon.daggerpractice.api.Cafe
import com.jeon.daggerpractice.impl.CompoCoffee
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CompoCompany{
    @Provides
    fun provideCompanyInfo(): Cafe{
        return CompoCoffee()
    }

}
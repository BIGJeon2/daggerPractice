package com.jeon.daggerpractice.obj

import com.jeon.daggerpractice.api.Cafe
import com.jeon.daggerpractice.impl.StarCoffee
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object StarCompany {
    @Provides
    fun provideCompanyInfo(): Cafe {
        return StarCoffee()
    }
}
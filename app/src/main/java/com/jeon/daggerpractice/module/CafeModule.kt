package com.jeon.daggerpractice.module

import com.jeon.daggerpractice.api.Cafe
import com.jeon.daggerpractice.impl.CompoCoffee
import com.jeon.daggerpractice.impl.StarCoffee
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
abstract class CafeModule {
    @CompoCoffeeQualifier
    @Binds
    abstract fun compoCoffeeImpl(compoCoffee: CompoCoffee): Cafe

    @StarCoffeeQualifier
    @Binds
    abstract fun starCoffeeImpl(starCoffee: StarCoffee): Cafe

}

@Qualifier
annotation class CompoCoffeeQualifier
@Qualifier
annotation class StarCoffeeQualifier

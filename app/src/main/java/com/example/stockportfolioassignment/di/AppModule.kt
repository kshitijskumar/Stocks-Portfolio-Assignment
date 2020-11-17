package com.example.stockportfolioassignment.di

import com.example.stockportfolioassignment.dummyData.DummyDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesDummyData() = DummyDataSource()
}
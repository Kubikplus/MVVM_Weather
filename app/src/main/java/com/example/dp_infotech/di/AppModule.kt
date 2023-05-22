package com.example.dp_infotech.di

import android.app.Application
import android.content.Context
import com.example.dp_infotech.data.RepoImplement
import com.example.dp_infotech.domain.repository.CityRepository
import com.example.dp_infotech.domain.usecases.CityUseCases
import com.example.dp_infotech.domain.usecases.GetCities
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideContext(application: Application):Context{
        return application.applicationContext
    }
    @Provides
    @Singleton
    fun provideNoteRepository(context: Context): CityRepository {
        return RepoImplement(context)
    }

}
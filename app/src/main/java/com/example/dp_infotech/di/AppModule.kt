package com.example.dp_infotech.di

import android.app.Application
import android.content.Context
import com.example.dp_infotech.common.Constant.BASE_URL
import com.example.dp_infotech.data.RepoImplement
import com.example.dp_infotech.data.WeatherRepoImpl
import com.example.dp_infotech.data.remote.WeatherAPI
import com.example.dp_infotech.domain.repository.CityRepository
import com.example.dp_infotech.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
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


    @Provides
    @Singleton
    fun provideWeatherApi():WeatherAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()

    }


}
package com.example.mapscompose.di

import android.app.Application
import androidx.room.Room
import com.example.mapscompose.data.ParkingSpotDataBase
import com.example.mapscompose.data.ParkingSpotRepositoryImpl
import com.example.mapscompose.domain.ParkingSpotRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideParkingSpotDataBase(app: Application): ParkingSpotDataBase {
        return Room.databaseBuilder(app, ParkingSpotDataBase::class.java, "PARKING_DATA_BASE")
            .build()
    }

    @Singleton
    @Provides
    fun provideParkingSpotRepository(dao: ParkingSpotDataBase): ParkingSpotRepository {
        return ParkingSpotRepositoryImpl(dao = dao.dao)
    }
}
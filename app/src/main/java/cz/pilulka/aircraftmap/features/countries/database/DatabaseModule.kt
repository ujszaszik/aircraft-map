package cz.pilulka.aircraftmap.features.countries.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    companion object {
        private const val DATABASE_NAME = "CountriesDatabase"
    }

    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext context: Context): CountriesDatabase {
        return Room.databaseBuilder(context, CountriesDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

}
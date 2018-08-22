package br.com.sailboat.template.di

import android.arch.persistence.room.Room
import android.content.Context
import br.com.sailboat.template.data.AppDatabase
import br.com.sailboat.template.data.repository.EntityRoomRepository
import br.com.sailboat.template.domain.repository.EntityRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME)
            .build()
    }

    @Provides
    @Singleton
    fun providesEntityRepository(appDatabase: AppDatabase): EntityRepository {
        return EntityRoomRepository(appDatabase.entityDao())
    }

}
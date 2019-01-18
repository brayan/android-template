package br.com.sailboat.template.di

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
        return AppDatabase.build(context)
    }

    @Provides
    @Singleton
    fun providesEntityRepository(appDatabase: AppDatabase): EntityRepository {
        return EntityRoomRepository(appDatabase.entityDao())
    }

}
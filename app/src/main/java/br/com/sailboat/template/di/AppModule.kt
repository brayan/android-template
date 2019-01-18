package br.com.sailboat.template.di

import android.app.Application
import android.content.Context
import br.com.sailboat.template.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun providesApplicationContext(): Context = application

    @Provides @Singleton fun providesRetrofit(): Retrofit {
        return RetrofitClient.build()
    }

}
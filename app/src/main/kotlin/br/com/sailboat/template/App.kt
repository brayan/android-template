package br.com.sailboat.template

import android.app.Application
import br.com.sailboat.template.di.*

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .uIModule(UIModule())
            .repositoryModule(RepositoryModule())
            .build()
    }
}
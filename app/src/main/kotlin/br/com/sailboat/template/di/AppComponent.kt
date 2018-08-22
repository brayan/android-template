package br.com.sailboat.template.di

import br.com.sailboat.template.ui.entity.details.EntityDetailsFragment
import br.com.sailboat.template.ui.entity.insert.EntityInsertFragment
import br.com.sailboat.template.ui.entity.list.EntityListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, UIModule::class, RepositoryModule::class])
interface AppComponent {

    fun inject(fragment: EntityListFragment)
    fun inject(fragment: EntityDetailsFragment)
    fun inject(fragment: EntityInsertFragment)

}
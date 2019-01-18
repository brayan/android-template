package br.com.sailboat.template.di

import br.com.sailboat.template.entitymvvm.EntityMVVMListFragment
import br.com.sailboat.template.entitymvp.details.EntityDetailsFragment
import br.com.sailboat.template.entitymvp.insert.EntityInsertFragment
import br.com.sailboat.template.entitymvp.list.EntityListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class, UIModule::class, RepositoryModule::class])
interface AppComponent {

    fun inject(fragment: EntityListFragment)
    fun inject(fragment: EntityDetailsFragment)
    fun inject(fragment: EntityInsertFragment)
    fun inject(fragment: EntityMVVMListFragment)

}
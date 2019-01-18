package br.com.sailboat.template.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.sailboat.template.base.mvvm.ViewModelFactory
import br.com.sailboat.template.base.mvvm.ViewModelKey
import br.com.sailboat.template.entitymvvm.EntityMVVMViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(EntityMVVMViewModel::class)
    internal abstract fun entityMvvmViewModel(viewModel: EntityMVVMViewModel): ViewModel

    //Add more ViewModels here
}
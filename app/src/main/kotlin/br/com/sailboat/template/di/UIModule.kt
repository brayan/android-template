package br.com.sailboat.template.di

import br.com.sailboat.template.ui.entity.details.EntityDetailsContract
import br.com.sailboat.template.ui.entity.details.EntityDetailsPresenter
import br.com.sailboat.template.ui.entity.insert.EntityInsertContract
import br.com.sailboat.template.ui.entity.insert.EntityInsertPresenter
import br.com.sailboat.template.ui.entity.list.EntityListContract
import br.com.sailboat.template.ui.entity.list.EntityListPresenter
import dagger.Module
import dagger.Provides

@Module
class UIModule {

    @Provides
    fun providesEntityListPresenter(presenter: EntityListPresenter): EntityListContract.Presenter {
        return presenter
    }

    @Provides
    fun providesEntityDetailsPresenter(presenter: EntityDetailsPresenter): EntityDetailsContract.Presenter {
        return presenter
    }

    @Provides
    fun providesEntityInsertPresenter(presenter: EntityInsertPresenter): EntityInsertContract.Presenter {
        return presenter
    }

}
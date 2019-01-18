package br.com.sailboat.template.entitymvp.list

import br.com.sailboat.template.base.mvp.BaseMvpContract
import br.com.sailboat.template.model.EntityView

interface EntityListContract {

    interface View : BaseMvpContract.View {
        fun updateList()
        fun showList()
        fun showEmptyView()
        fun showErrorLoadingEntities()
        fun hideList()
        fun hideEmptyView()
        fun navigateToEntityDetails(id: Long)
        fun navigateToInsertEntity()
    }

    interface Presenter : BaseMvpContract.Presenter {
        fun onClickNewEntity()
        fun onClickEntity(position: Int)
        fun getEntities(): List<EntityView>
    }
}
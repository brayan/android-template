package br.com.sailboat.template.ui.entity.list

import br.com.sailboat.template.ui.base.BaseMvpContract
import br.com.sailboat.template.ui.model.EntityView

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
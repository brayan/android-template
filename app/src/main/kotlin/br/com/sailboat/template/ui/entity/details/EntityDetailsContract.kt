package br.com.sailboat.template.ui.entity.details

import br.com.sailboat.template.ui.base.BaseMvpContract
import br.com.sailboat.template.ui.model.RecyclerViewItem

interface EntityDetailsContract {

    interface View : BaseMvpContract.View {
        fun extractEntityId(): Long
        fun navigateToEditEntity(entityId: Long)
        fun updateDetails()
        fun closeWithFailureOnLoadDetails()
        fun showDeleteMessage()
        fun closeWithSuccessOnDelete()
        fun showErrorMessageOnDelete()
    }

    interface Presenter : BaseMvpContract.Presenter {
        fun onClickDelete()
        fun getDetails(): List<RecyclerViewItem>
        fun onClickEdit()
        fun onClickYesOnDelete()
    }

}
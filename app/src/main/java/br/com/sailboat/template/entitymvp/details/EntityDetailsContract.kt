package br.com.sailboat.template.entitymvp.details

import br.com.sailboat.template.base.mvp.BaseMvpContract
import br.com.sailboat.template.model.RecyclerViewItem

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
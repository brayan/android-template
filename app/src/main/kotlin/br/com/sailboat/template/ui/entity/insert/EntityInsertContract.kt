package br.com.sailboat.template.ui.entity.insert

import br.com.sailboat.template.ui.base.BaseMvpContract

interface EntityInsertContract {

    interface View : BaseMvpContract.View {
        fun extractEntityId(): Long
        fun setTitleNew()
        fun setTitleEdit()
        fun setName(name: String)
        fun setDescription(description: String)
        fun setQuantity(quantity: String)
        fun setPrice(price: String)
        fun getName(): String
        fun getDescription(): String
        fun getQuantity(): String
        fun getPrice(): String
        fun showErrorOnSave()
        fun showErrorNameNotFilled()
        fun showErrorQuantityNegative()
        fun showErrorPriceInvalid()
        fun showCancelMessage()
        fun closeWithSuccessOnEdit()
        fun closeWithSuccessOnInsert()
    }

    interface Presenter : BaseMvpContract.Presenter {
        fun onClickSave()
        fun onBackPressed()
    }

}
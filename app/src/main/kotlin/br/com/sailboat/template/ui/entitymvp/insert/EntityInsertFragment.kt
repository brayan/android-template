package br.com.sailboat.template.ui.entity.insert

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import br.com.sailboat.template.App
import br.com.sailboat.template.R
import br.com.sailboat.template.ui.base.mvp.BaseMvpFragment
import br.com.sailboat.template.ui.dialog.OptionDialog
import br.com.sailboat.template.ui.helper.Extras
import kotlinx.android.synthetic.main.appbar.*
import kotlinx.android.synthetic.main.frg_entity_insert.*

class EntityInsertFragment : BaseMvpFragment<EntityInsertContract.Presenter>(), EntityInsertContract.View {

    override fun inject() {
        (activity?.application as App).appComponent.inject(this)
    }

    override fun getLayoutId() = R.layout.frg_entity_insert

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_save, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
        R.id.menu_save -> {
            presenter.onClickSave()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun initViews() {
        initToolbar()
    }

    override fun extractEntityId() = Extras.getEntityId(arguments)

    override fun setTitleNew() {
        toolbar.setTitle(R.string.title_new_entity)
    }

    override fun setTitleEdit() {
        toolbar.setTitle(R.string.title_edit_entity)
    }

    override fun setName(name: String) {
        edtName.setText(name)
        edtName.setSelection(edtName.length())
    }

    override fun setDescription(description: String) {
        edtDescription.setText(description)
    }

    override fun setQuantity(quantity: String) {
        edtQuantity.setText(quantity)
    }

    override fun setPrice(price: String) {
        edtPrice.setText(price)
    }

    override fun getName() = edtName.text.toString()

    override fun getDescription() = edtDescription.text.toString()

    override fun getQuantity() = edtQuantity.text.toString()

    override fun getPrice() = edtPrice.text.toString()

    override fun showErrorOnSave() {
        showErrorMessage(R.string.dlg_msg_error)
    }

    override fun showErrorNameNotFilled() {
        showErrorMessage(R.string.dlg_msg_error_product_name_not_filled)
    }

    override fun showErrorQuantityNegative() {
        showErrorMessage(R.string.product_quantity_cant_be_negative)
    }

    override fun showErrorPriceInvalid() {
        showErrorMessage(R.string.dlg_msg_error_price_invalid)
    }

    override fun showCancelMessage() {
        val dialog = OptionDialog()
        dialog.message = R.string.dlg_msg_cancel
        dialog.yesOption = R.string.dlg_option_pos_yes
        dialog.noOption = R.string.dlg_option_neg_no
        dialog.onClickPositive = DialogInterface.OnClickListener { _, _ ->
            activity?.finish()
        }
        dialog.show(fragmentManager, "CANCEL_OPERATION_DIALOG")
    }

    override fun closeWithSuccessOnEdit() {
        closeWithSuccess(R.string.fdb_msg_entity_edited_successfully)
    }

    override fun closeWithSuccessOnInsert() {
        closeWithSuccess(R.string.fdb_msg_entity_inserted_successfully)
    }

    fun onBackPressed() {
        presenter.onBackPressed()
    }

    private fun initToolbar() {
        toolbar.run {
            (activity as AppCompatActivity).setSupportActionBar(this)
            setNavigationIcon(R.drawable.ic_close_white_24dp)
            setNavigationOnClickListener { presenter.onBackPressed() }
        }
    }

}
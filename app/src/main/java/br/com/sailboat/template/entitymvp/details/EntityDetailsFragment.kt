package br.com.sailboat.template.entitymvp.details

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import br.com.sailboat.template.App
import br.com.sailboat.template.R
import br.com.sailboat.template.base.mvp.BaseMvpFragment
import br.com.sailboat.template.dialog.OptionDialog
import br.com.sailboat.template.entitymvp.insert.EntityInsertActivity
import br.com.sailboat.template.helper.Extras
import kotlinx.android.synthetic.main.appbar_scroll.*
import kotlinx.android.synthetic.main.fab.*
import kotlinx.android.synthetic.main.recycler.*

class EntityDetailsFragment : BaseMvpFragment<EntityDetailsContract.Presenter>(), EntityDetailsContract.View {

    override fun inject() {
        (activity?.application as App).appComponent.inject(this)
    }

    override fun getLayoutId() = R.layout.frg_details

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_delete, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
        R.id.menu_delete -> {
            presenter.onClickDelete()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun initViews() {
        initToolbar()
        initRecyclerView()
        initFab()
    }

    override fun extractEntityId() = Extras.getEntityId(arguments)

    override fun navigateToEditEntity(entityId: Long) {
        EntityInsertActivity.startEdit(this, entityId)
    }

    override fun updateDetails() {
        recycler.adapter.notifyDataSetChanged()
    }

    override fun closeWithFailureOnLoadDetails() {
        closeWithFailure(R.string.dlg_msg_error_details)
    }

    override fun showDeleteMessage() {
        val dialog = OptionDialog()
        dialog.message = R.string.dlg_msg_delete_entity
        dialog.yesOption = R.string.delete
        dialog.onClickPositive = DialogInterface.OnClickListener { _, _ ->
            presenter.onClickYesOnDelete()
        }
        dialog.show(fragmentManager, "DELETE_DIALOG")
    }

    override fun closeWithSuccessOnDelete() {
        closeWithSuccess(R.string.fdb_msg_entity_deleted_successfully)
    }

    override fun showErrorMessageOnDelete() {
        showErrorMessage(R.string.dlg_msg_error_delete_entity)
    }

    private fun initToolbar() {
        toolbar.run {
            (activity as AppCompatActivity).setSupportActionBar(this)
            setTitle(R.string.title_entity_details)
            setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
            setNavigationOnClickListener { activity?.onBackPressed() }
        }
    }

    private fun initRecyclerView() {
        recycler.run {
            adapter = EntityDetailsAdapter(object : EntityDetailsAdapter.Callback {
                override fun getEntityDetails() = presenter.getDetails()
            })
        }
    }

    private fun initFab() {
        fab.setImageResource(R.drawable.ic_edit_white_24dp)
        fab.setOnClickListener { presenter.onClickEdit() }
    }

}
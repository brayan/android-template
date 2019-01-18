package br.com.sailboat.template.ui.entity.list

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import br.com.sailboat.template.App
import br.com.sailboat.template.R
import br.com.sailboat.template.ui.base.mvp.BaseMvpFragment
import br.com.sailboat.template.ui.entity.details.EntityDetailsActivity
import br.com.sailboat.template.ui.entity.insert.EntityInsertActivity
import br.com.sailboat.template.ui.model.EntityView
import kotlinx.android.synthetic.main.appbar_scroll.*
import kotlinx.android.synthetic.main.ept_view.*
import kotlinx.android.synthetic.main.fab.*
import kotlinx.android.synthetic.main.recycler.*

class EntityListFragment : BaseMvpFragment<EntityListContract.Presenter>(), EntityListContract.View {

    companion object {
        fun newInstance(): Fragment {
            return EntityListFragment()
        }
    }

    override fun inject() {
        (activity?.application as App).appComponent.inject(this)
    }

    override fun getLayoutId() = R.layout.frg_entity_list

    override fun initViews() {
        initToolbar()
        initRecyclerView()
        initFab()
        initEmptyView()
    }

    override fun updateList() {
        (recycler.adapter as EntityListAdapter).notifyDataSetChanged()
    }

    override fun navigateToEntityDetails(id: Long) {
        EntityDetailsActivity.startFrom(this, id)
    }

    override fun navigateToInsertEntity() {
        EntityInsertActivity.startFrom(this)
    }

    override fun showList() {
        recycler.visibility = View.VISIBLE
    }

    override fun hideList() {
        recycler.visibility = View.GONE
    }

    override fun showEmptyView() {
        llEptView.visibility = View.VISIBLE
    }

    override fun hideEmptyView() {
        llEptView.visibility = View.GONE
    }

    override fun showErrorLoadingEntities() {
        showErrorMessage(R.string.dlg_msg_error_loading_products)
    }

    private fun initToolbar() {
        toolbar.run {
            (activity as AppCompatActivity).setSupportActionBar(this)
            setTitle(R.string.title_entities)
        }
    }

    private fun initRecyclerView() {
        recycler.run {
            adapter = EntityListAdapter(object : EntityListAdapter.Callback {
                override fun getEntities(): List<EntityView> {
                    return presenter?.getEntities() ?: emptyList()
                }
                override fun onClickEntity(position: Int) {
                    presenter?.onClickEntity(position)
                }
            })
        }
    }

    private fun initFab() {
        fab.setOnClickListener { presenter?.onClickNewEntity() }
    }

    private fun initEmptyView() {
        // TODO
    }

}
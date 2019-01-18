package br.com.sailboat.template.entitymvvm

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.widget.Toast
import br.com.sailboat.template.App
import br.com.sailboat.template.R
import br.com.sailboat.template.base.mvvm.BaseMVVMFragment
import br.com.sailboat.template.entitymvvm.EntityMVVMViewModel
import br.com.sailboat.template.helper.EventObserver

class EntityMVVMListFragment : BaseMVVMFragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(EntityMVVMViewModel::class.java)
    }

    companion object {
        fun newInstance(): Fragment {
            return EntityMVVMListFragment()
        }
    }

    override fun inject() {
        (activity?.application as App).appComponent.inject(this)
    }

    override fun getLayoutId() = R.layout.frg_entity_list

    override fun initViews() {
        viewModel.entities.observe(this, Observer {

        })

        viewModel.errorMessage.observe(this, EventObserver { errorMsg ->
            Toast.makeText(this.context, errorMsg, Toast.LENGTH_LONG).show()
        })
    }

}
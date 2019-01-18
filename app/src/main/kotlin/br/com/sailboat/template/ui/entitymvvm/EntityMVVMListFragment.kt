package br.com.sailboat.template.ui.entity_mvvm

import android.arch.lifecycle.Observer
import android.support.v4.app.Fragment
import android.widget.Toast
import br.com.sailboat.template.App
import br.com.sailboat.template.R
import br.com.sailboat.template.ui.base.mvvm.BaseMVVMFragment
import br.com.sailboat.template.ui.helper.EventObserver

class EntityMvvmListFragment : BaseMVVMFragment() {

//    private val viewModel: EntityMvvmViewModel
//            by lazy {
//                ViewModelProviders.of(this, viewModelFactory).get(EntityMvvmViewModel::class.java)
//            }

    private lateinit var viewModel: EntityMvvmViewModel

    companion object {
        fun newInstance(): Fragment {
            return EntityMvvmListFragment()
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
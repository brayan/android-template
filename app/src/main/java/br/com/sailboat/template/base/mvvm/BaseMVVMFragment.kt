package br.com.sailboat.template.base.mvvm

import android.arch.lifecycle.ViewModelProvider
import br.com.sailboat.template.base.BaseFragment
import javax.inject.Inject

abstract class BaseMVVMFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

}
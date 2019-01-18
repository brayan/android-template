package br.com.sailboat.template.base.mvp

import android.content.Intent
import android.os.Bundle
import android.view.View
import br.com.sailboat.template.base.BaseFragment
import javax.inject.Inject

abstract class BaseMvpFragment<P : BaseMvpContract.Presenter> : BaseFragment(), BaseMvpContract.View {

    @Inject
    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        retainInstance = true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detachView()
    }

    override fun postResult(requestCode: Int, data: Intent?) {
        super.postResult(requestCode, data)
        presenter.postResult()
    }

}
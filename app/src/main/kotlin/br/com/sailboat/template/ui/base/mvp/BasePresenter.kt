package br.com.sailboat.template.ui.base.mvp

abstract class BasePresenterKotlin<V : BaseMvpContract.View> : BaseMvpContract.Presenter {

    private var firstSession = true
    var view: V? = null

    override fun onViewCreated() {
        if (firstSession) {
            create()
            firstSession = false
        } else {
            restart()
        }
    }

    override fun attachView(view: BaseMvpContract.View?) {
        this.view = view as V
    }

    override fun onDestroyView() {
        view = null
    }

    open fun create() {}
    open fun restart() {}

    override fun postResult() {}




}
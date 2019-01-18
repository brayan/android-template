package br.com.sailboat.template.base.mvp

abstract class BasePresenter<V : BaseMvpContract.View> : BaseMvpContract.Presenter {

    private var firstSession = true
    var view: V? = null

    override fun attachView(view: BaseMvpContract.View?) {
        this.view = view as V
        onViewAttached()
    }

    override fun detachView() {
        view = null
    }

    private fun onViewAttached() {
        if (firstSession) {
            setUp()
            firstSession = false
        } else {
            restart()
        }
        postAttached()
    }

    open fun setUp() {}
    open fun restart() {}
    open fun postAttached() {}

    override fun postResult() {}
}
package br.com.sailboat.template.base.mvp

interface BaseMvpContract {

    interface View {
        fun showProgress()
        fun hideProgress()
        fun closeKeyboard()
        fun closeWithSuccess()
        fun closeWithFailure()
        fun closeWithFailureDefaultMessage()
        fun disableKeyboardOnStart()
        fun logError(e: Exception)
    }

    interface Presenter {
        fun attachView(view: BaseMvpContract.View?)
        fun detachView()
        fun postResult()
    }

}
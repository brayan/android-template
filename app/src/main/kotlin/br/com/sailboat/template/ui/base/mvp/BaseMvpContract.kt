package br.com.sailboat.template.ui.base

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
        fun setView(view: BaseMvpContract.View?)
        fun onViewCreated()
        fun onDestroyView()
        fun postResult()
    }

}
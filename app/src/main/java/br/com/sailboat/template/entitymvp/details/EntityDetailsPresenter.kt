package br.com.sailboat.template.entitymvp.details

import br.com.sailboat.template.domain.model.EntityHelper
import br.com.sailboat.template.domain.usecase.DeleteEntity
import br.com.sailboat.template.base.mvp.BasePresenter
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class EntityDetailsPresenter @Inject constructor(
    private val viewModel: EntityDetailsViewModel,
    private val getProductDetails: GetEntityDetails,
    private val deleteProduct: DeleteEntity
) : BasePresenter<EntityDetailsContract.View>(), EntityDetailsContract.Presenter {

    override fun setUp() {
        extractArgs()
        loadDetails()
    }

    override fun restart() {
        view?.updateDetails()
    }

    override fun postResult() {
        super.postResult()
        loadDetails()
    }

    override fun onClickEdit() {
        view?.navigateToEditEntity(viewModel.entityId)
    }

    override fun onClickDelete() {
        view?.showDeleteMessage()
    }

    override fun getDetails() = viewModel.entityDetails

    override fun onClickYesOnDelete() {
        launch(UI) {
            try {
                view?.showProgress()
                async(CommonPool) { deleteProduct.execute(viewModel.entityId) }.await()

                view?.closeWithSuccessOnDelete()
            } catch (e: Exception) {
                view?.logError(e)
                view?.showErrorMessageOnDelete()
            } finally {
                view?.hideProgress()
            }
        }
    }

    private fun extractArgs() {
        viewModel.entityId = view?.extractEntityId() ?: EntityHelper.NO_ID
    }

    private fun loadDetails() {
        launch(UI) {
            try {
                view?.showProgress()
                val details = async(CommonPool) { getProductDetails.execute(viewModel.entityId) }.await()

                viewModel.entityDetails.clear()
                viewModel.entityDetails.addAll(details)

                view?.updateDetails()
            } catch (e: Exception) {
                view?.logError(e)
                view?.closeWithFailureOnLoadDetails()
            } finally {
                view?.hideProgress()
            }
        }
    }

}
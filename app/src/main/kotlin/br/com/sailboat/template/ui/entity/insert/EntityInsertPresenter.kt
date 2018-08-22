package br.com.sailboat.template.ui.entity.insert

import br.com.sailboat.template.domain.model.Entity
import br.com.sailboat.template.domain.model.EntityHelper
import br.com.sailboat.template.domain.usecase.GetEntity
import br.com.sailboat.template.domain.usecase.SaveEntity
import br.com.sailboat.template.domain.usecase.ValidateEntity
import br.com.sailboat.template.ui.base.BasePresenter
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import java.math.BigDecimal
import javax.inject.Inject

class EntityInsertPresenter @Inject constructor(
    private val viewModel: EntityInsertViewModel,
    private val getEntity: GetEntity,
    private val saveEntity: SaveEntity,
    private val validateEntity: ValidateEntity
) : BasePresenter<EntityInsertContract.View>(), EntityInsertContract.Presenter {

    override fun create() {
        extractArgs()
        if (hasEntityToEdit()) {
            startEditingEntity()
        } else {
            updateContentViews()
        }
    }

    override fun restart() {
        updateContentViews()
    }

    override fun onClickSave() {
        try {
            view?.closeKeyboard()
            extractInfoFromViews()
            val entity = buildEntityFromViewModel()
            save(entity)
        } catch (e: Exception) {
            view?.logError(e)
            view?.showErrorOnSave()
        }
    }

    override fun onBackPressed() {
        view?.closeKeyboard()
        view?.showCancelMessage()
    }

    private fun extractInfoFromViews() {
        viewModel.name = view?.getName() ?: ""
        viewModel.description = view?.getDescription() ?: ""
        viewModel.quantity = view?.getQuantity()?.toIntOrNull() ?: 0
        viewModel.price = view?.getPrice()?.toDoubleOrNull() ?: 0.0
    }

    private fun buildEntityFromViewModel(): Entity {
        return Entity(
            viewModel.entityId,
            viewModel.name,
            viewModel.description,
            viewModel.quantity,
            BigDecimal.valueOf(viewModel.price)
        )
    }

    private fun extractArgs() {
        viewModel.entityId = view?.extractEntityId() ?: EntityHelper.NO_ID
    }

    private fun startEditingEntity() {
        launch(UI) {
            try {
                view?.showProgress()
                val entity = async(CommonPool) { getEntity.execute(viewModel.entityId) }.await()
                viewModel.name = entity.name
                viewModel.description = entity.description
                viewModel.quantity = entity.quantity
                viewModel.price = entity.price.toDouble()

                view?.disableKeyboardOnStart()
                updateInputTexts()
                updateContentViews()

            } catch (e: Exception) {
                view?.logError(e)
                view?.closeWithFailureDefaultMessage()
            } finally {
                view?.hideProgress()
            }
        }
    }

    private fun save(entity: Entity) {
        launch(UI) {
            try {
                view?.showProgress()

                val invalidFields = async(CommonPool) { validateEntity.execute(entity) }.await()
                if (invalidFields.isNotEmpty()) {
                    handleInvalidFields(invalidFields)
                    return@launch
                }

                async(CommonPool) { saveEntity.execute(entity) }.await()

                if (hasEntityToEdit()) {
                    view?.closeWithSuccessOnEdit()
                } else {
                    view?.closeWithSuccessOnInsert()
                }
            } catch (e: Exception) {
                view?.logError(e)
                view?.showErrorOnSave()
            } finally {
                view?.hideProgress()
            }
        }

    }

    private fun updateContentViews() {
        updateTitle()
    }

    private fun updateTitle() {
        if (hasEntityToEdit()) {
            view?.setTitleEdit()
        } else {
            view?.setTitleNew()
        }
    }

    private fun hasEntityToEdit() = viewModel.entityId != EntityHelper.NO_ID

    private fun updateInputTexts() {
        view?.setName(viewModel.name)
        view?.setDescription(viewModel.description)
        view?.setQuantity(viewModel.quantity.toString())
        view?.setPrice(viewModel.price.toString())
    }

    private fun handleInvalidFields(invalidFields: List<ValidateEntity.InvalidFields>) {
        invalidFields.takeIf { it.isNotEmpty() }?.run {
            when (get(0)) {
                ValidateEntity.InvalidFields.NAME_NOT_FILLED -> {
                    view?.showErrorNameNotFilled()
                }
                ValidateEntity.InvalidFields.QUANTITY_NEGATIVE -> {
                    view?.showErrorQuantityNegative()
                }
                ValidateEntity.InvalidFields.PRICE_INVALID -> {
                    view?.showErrorPriceInvalid()
                }
            }
        }
    }

}



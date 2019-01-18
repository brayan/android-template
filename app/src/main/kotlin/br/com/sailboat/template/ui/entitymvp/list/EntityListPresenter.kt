package br.com.sailboat.template.ui.entity.list

import br.com.sailboat.template.domain.usecase.GetEntities
import br.com.sailboat.template.ui.base.mvp.BasePresenter
import br.com.sailboat.template.ui.model.mapper.EntityViewMapper
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class EntityListPresenter @Inject constructor(
    private val viewModel: EntityListViewModel,
    private val getEntities: GetEntities
): BasePresenter<EntityListContract.View>(), EntityListContract.Presenter {

    override fun setUp() {
        loadEntities()
    }

    override fun restart() {
        updateEntities()
    }

    override fun postResult() {
        super.postResult()
        loadEntities()
    }

    override fun onClickEntity(position: Int) {
        val entity = viewModel.entities[position]
        view?.navigateToEntityDetails(entity.id)
    }

    override fun onClickNewEntity() {
        view?.navigateToInsertEntity()
    }

    override fun getEntities() = viewModel.entities

    private fun loadEntities() {

        launch(UI) {
            try {
                view?.showProgress()

                val products = async(CommonPool) { getEntities.execute(Unit) }.await()

                viewModel.entities.clear()
                viewModel.entities.addAll(EntityViewMapper().transform(products))

                updateEntities()
            } catch (e: Exception) {
                view?.logError(e)
                view?.showErrorLoadingEntities()
            } finally {
                view?.hideProgress()
            }
        }
    }

    private fun updateEntities() {
        view?.updateList()

        if (viewModel.entities.isEmpty()) {
            view?.hideList()
            view?.showEmptyView()
        } else {
            view?.showList()
            view?.hideEmptyView()
        }
    }

}
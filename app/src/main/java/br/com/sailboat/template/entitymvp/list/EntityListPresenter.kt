package br.com.sailboat.template.entitymvp.list

import br.com.sailboat.template.base.mvp.BasePresenter
import br.com.sailboat.template.domain.usecase.GetEntities
import br.com.sailboat.template.model.mapper.EntityViewMapper
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.android.Main
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class EntityListPresenter @Inject constructor(
    private val viewModel: EntityListViewModel,
    private val getEntitiesUseCase: GetEntities
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

        GlobalScope.launch(Dispatchers.Main) {
            try {
                view?.showProgress()

                val entities = async(Dispatchers.Default) { getEntitiesUseCase() }.await()

                viewModel.entities.clear()
                viewModel.entities.addAll(EntityViewMapper().transform(entities))

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
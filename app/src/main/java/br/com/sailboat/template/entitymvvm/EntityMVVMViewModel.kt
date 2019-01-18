package br.com.sailboat.template.entitymvvm

import android.arch.lifecycle.MutableLiveData
import br.com.sailboat.template.base.mvvm.BaseViewModel
import br.com.sailboat.template.domain.usecase.GetEntities
import br.com.sailboat.template.helper.Event
import br.com.sailboat.template.model.EntityView
import br.com.sailboat.template.model.mapper.EntityViewMapper
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.async
import javax.inject.Inject

class EntityMVVMViewModel @Inject constructor(private val getEntities: GetEntities) : BaseViewModel() {

    var entities : MutableLiveData<List<EntityView>> = MutableLiveData()
    val errorMessage = MutableLiveData<Event<String>>()

    fun setUp() {
        launchMain {
            val entityList = GlobalScope.async(Dispatchers.Default) {
                    EntityViewMapper().transform(getEntities())
                }.await()

            entities.value = entityList
        }
    }

}
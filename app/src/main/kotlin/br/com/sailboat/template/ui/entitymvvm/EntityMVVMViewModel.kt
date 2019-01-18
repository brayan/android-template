package br.com.sailboat.template.ui.entity_mvvm

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.sailboat.template.domain.usecase.GetEntities
import br.com.sailboat.template.ui.helper.Event
import br.com.sailboat.template.ui.model.EntityView
import br.com.sailboat.template.ui.model.mapper.EntityViewMapper
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.android.Main
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class EntityMvvmViewModel @Inject constructor(private val getEntities: GetEntities) : ViewModel() {

    var entities : MutableLiveData<List<EntityView>> = MutableLiveData()

    val errorMessage = MutableLiveData<Event<String>>()


    fun setUp() {
        GlobalScope.launch(Dispatchers.Main) {
            val entityList = async(Dispatchers.Default) {
                    EntityViewMapper().transform(getEntities())
                }.await()

            entities.value = entityList
        }
    }

}
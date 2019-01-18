package br.com.sailboat.template.entitymvp.list

import br.com.sailboat.template.model.EntityView
import javax.inject.Inject

class EntityListViewModel @Inject constructor() {

    var entities = mutableListOf<EntityView>()

}
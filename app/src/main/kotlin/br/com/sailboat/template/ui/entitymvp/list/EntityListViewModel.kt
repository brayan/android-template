package br.com.sailboat.template.ui.entity.list

import br.com.sailboat.template.ui.model.EntityView
import javax.inject.Inject

class EntityListViewModel @Inject constructor() {

    var entities = mutableListOf<EntityView>()

}
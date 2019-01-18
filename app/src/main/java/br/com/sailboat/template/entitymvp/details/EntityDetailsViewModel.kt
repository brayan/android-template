package br.com.sailboat.template.entitymvp.details

import br.com.sailboat.template.domain.model.EntityHelper
import br.com.sailboat.template.model.RecyclerViewItem
import javax.inject.Inject

class EntityDetailsViewModel @Inject constructor() {

    var entityId = EntityHelper.NO_ID
    val entityDetails = mutableListOf<RecyclerViewItem>()

}
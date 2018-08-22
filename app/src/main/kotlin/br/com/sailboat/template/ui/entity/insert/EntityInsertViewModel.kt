package br.com.sailboat.template.ui.entity.insert

import br.com.sailboat.template.domain.model.EntityHelper
import javax.inject.Inject

class EntityInsertViewModel @Inject constructor() {

    var hasChange = false
    var entityId = EntityHelper.NO_ID
    var name: String = ""
    var description: String = ""
    var quantity: Int = 0
    var price: Double = 0.0

}
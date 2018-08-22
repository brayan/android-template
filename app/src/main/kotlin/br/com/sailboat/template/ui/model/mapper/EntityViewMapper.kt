package br.com.sailboat.template.ui.model.mapper

import br.com.sailboat.template.domain.model.Entity
import br.com.sailboat.template.ui.model.EntityView

class EntityViewMapper {

    fun transform(entity: Entity): EntityView {
        return EntityView(entity.id, entity.name, entity.description, entity.quantity, entity.price.toDouble())
    }

    fun transform(product: List<Entity>): List<EntityView> {
        return product.map { transform(it) }
    }

}
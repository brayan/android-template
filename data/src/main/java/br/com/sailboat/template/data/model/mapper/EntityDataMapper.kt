package br.com.sailboat.template.data.model.mapper


import br.com.sailboat.template.data.model.EntityData
import br.com.sailboat.template.domain.model.Entity
import java.math.BigDecimal

class EntityDataMapper {

    fun transform(entity: EntityData): Entity {
        return Entity(entity.id, entity.name, entity.description, entity.quantity, BigDecimal(entity.price.toString()))
    }

    fun transform(entitiesData: List<EntityData>): List<Entity> {
        return entitiesData.map { transform(it) }
    }

    fun transform(entity: Entity) = EntityData(
        id = entity.id,
        name = entity.name,
        description = entity.description,
        quantity = entity.quantity,
        price = entity.price.toDouble(),
        enabled = true,
        dateTime = ""
    )
}
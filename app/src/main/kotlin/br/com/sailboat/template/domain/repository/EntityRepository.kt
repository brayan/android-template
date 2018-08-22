package br.com.sailboat.template.domain.repository

import br.com.sailboat.template.domain.model.Entity

interface EntityRepository {
    fun getEntity(entityId: Long): Entity
    fun getEntities(): List<Entity>
    fun insert(entity: Entity)
    fun update(entity: Entity)
    fun remove(entity: Entity)
}
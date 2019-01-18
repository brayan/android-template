package br.com.sailboat.template.data.repository

import br.com.sailboat.template.data.dao.EntityDao
import br.com.sailboat.template.data.model.mapper.EntityDataMapper
import br.com.sailboat.template.domain.model.Entity
import br.com.sailboat.template.domain.repository.EntityRepository

class EntityRoomRepository(var entityDao: EntityDao) : EntityRepository {

    val mapper = EntityDataMapper()

    override fun getEntities(): List<Entity> {
        val products = entityDao.getAll()
        return mapper.transform(products)
    }

    override fun getEntity(entityId: Long): Entity {
        val entity = entityDao.getEntity(entityId)
        return mapper.transform(entity)
    }

    override fun remove(entity: Entity) {
        entityDao.delete(mapper.transform(entity))
    }

    override fun insert(entity: Entity) {
        entityDao.insert(mapper.transform(entity))
    }

    override fun update(entity: Entity) {
        entityDao.update(mapper.transform(entity))
    }


}
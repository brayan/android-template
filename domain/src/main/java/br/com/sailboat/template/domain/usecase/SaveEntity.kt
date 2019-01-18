package br.com.sailboat.template.domain.usecase

import br.com.sailboat.template.domain.UseCaseWithParams
import br.com.sailboat.template.domain.model.Entity
import br.com.sailboat.template.domain.model.EntityHelper
import br.com.sailboat.template.domain.repository.EntityRepository
import javax.inject.Inject

class SaveEntity @Inject constructor(private val entityRepository: EntityRepository) : UseCaseWithParams<Entity, Unit>() {

    override fun execute(entity: Entity) {
        if (entity.id == EntityHelper.NO_ID) {
            entityRepository.insert(entity)
        } else {
            entityRepository.update(entity)
        }
    }

}
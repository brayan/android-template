package br.com.sailboat.template.domain.usecase

import br.com.sailboat.template.domain.UseCaseWithParams
import br.com.sailboat.template.domain.model.Entity
import br.com.sailboat.template.domain.repository.EntityRepository
import javax.inject.Inject

class GetEntity @Inject constructor(private val entityRepository: EntityRepository) : UseCaseWithParams<Long, Entity>() {

    override fun execute(entityId: Long) = entityRepository.getEntity(entityId)

}
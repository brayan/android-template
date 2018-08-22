package br.com.sailboat.template.domain.usecase

import br.com.sailboat.template.domain.UseCase
import br.com.sailboat.template.domain.model.Entity
import br.com.sailboat.template.domain.repository.EntityRepository
import javax.inject.Inject

class GetEntity @Inject constructor(private val entityRepository: EntityRepository) : UseCase<Long, Entity>() {

    override fun execute(entityId: Long) = entityRepository.getEntity(entityId)

}
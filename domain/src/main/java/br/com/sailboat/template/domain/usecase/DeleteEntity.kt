package br.com.sailboat.template.domain.usecase

import br.com.sailboat.template.domain.UseCaseWithParams
import br.com.sailboat.template.domain.repository.EntityRepository
import javax.inject.Inject

class DeleteEntity  @Inject constructor(private val entityRepository: EntityRepository) : UseCaseWithParams<Long, Unit>() {

    override fun execute(entityId: Long) {
        val entity = entityRepository.getEntity(entityId)
        entityRepository.remove(entity)
    }

}
package br.com.sailboat.template.domain.usecase

import br.com.sailboat.template.domain.UseCase
import br.com.sailboat.template.domain.model.Entity
import br.com.sailboat.template.domain.repository.EntityRepository
import javax.inject.Inject

class GetEntities @Inject constructor(private val entityRepository: EntityRepository) : UseCase<Unit, List<Entity>>() {

    override fun execute(params: Unit) = entityRepository.getEntities()

}
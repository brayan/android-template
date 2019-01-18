package br.com.sailboat.template.domain.usecase

import br.com.sailboat.template.domain.UseCaseWithParams
import br.com.sailboat.template.domain.model.Entity
import javax.inject.Inject

class ValidateEntity @Inject constructor() : UseCaseWithParams<Entity, List<ValidateEntity.InvalidFields>>() {

    override fun execute(entity: Entity): List<InvalidFields> {
        val invalidFields = mutableListOf<InvalidFields>()
        validateName(entity, invalidFields)
        validateQuantity(entity, invalidFields)
        validatePrice(entity, invalidFields)

        return invalidFields
    }

    private fun validateName(entity: Entity, invalidFields: MutableList<InvalidFields>) {
        if (entity.name.trim().isBlank()) {
            invalidFields.add(InvalidFields.NAME_NOT_FILLED)
        }
    }

    private fun validateQuantity(entity: Entity, invalidFields: MutableList<InvalidFields>) {
        if (entity.quantity < 0) {
            invalidFields.add(InvalidFields.QUANTITY_NEGATIVE)
        }
    }

    private fun validatePrice(entity: Entity, invalidFields: MutableList<InvalidFields>) {
        if (entity.price.toDouble() < 0.0) {
            invalidFields.add(InvalidFields.PRICE_INVALID)
        }
    }

    enum class InvalidFields {
        NAME_NOT_FILLED, QUANTITY_NEGATIVE, PRICE_INVALID
    }


}
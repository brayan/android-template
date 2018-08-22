package br.com.sailboat.template.ui.entity.details

import android.content.Context
import br.com.sailboat.template.R
import br.com.sailboat.template.domain.UseCase
import br.com.sailboat.template.domain.helper.DecimalHelper
import br.com.sailboat.template.domain.repository.EntityRepository
import br.com.sailboat.template.ui.model.LabelAndValueModel
import br.com.sailboat.template.ui.model.RecyclerViewItem
import br.com.sailboat.template.ui.model.TitleModel
import javax.inject.Inject

class GetEntityDetails @Inject constructor(
    private val context: Context,
    private val entityRepository: EntityRepository
) :
    UseCase<Long, List<RecyclerViewItem>>() {

    override fun execute(entityId: Long): List<RecyclerViewItem> {
        var details = mutableListOf<RecyclerViewItem>()

        val entity = entityRepository.getEntity(entityId)

        details.add(TitleModel(title = entity.name))

        details.add(LabelAndValueModel(
                label = context.getString(R.string.label_entity_description),
                value = entity.description))

        details.add(LabelAndValueModel(
                label = context.getString(R.string.label_entity_quantity),
                value = entity.quantity.toString()))

        details.add(LabelAndValueModel(
            label = context.getString(R.string.label_entity_price),
            value = DecimalHelper.toCurrency(entity.price.toDouble())))

        return details
    }

}
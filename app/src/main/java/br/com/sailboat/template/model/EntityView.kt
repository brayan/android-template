package br.com.sailboat.template.model

import br.com.sailboat.template.model.RecyclerViewItem
import br.com.sailboat.template.model.ViewType

class EntityView(
    var id: Long = -1,
    val name: String,
    val description: String,
    val quantity: Int,
    val price: Double,
    override val viewType: Int = ViewType.ENTITY.ordinal
) : RecyclerViewItem
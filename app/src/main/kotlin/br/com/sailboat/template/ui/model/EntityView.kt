package br.com.sailboat.template.ui.model

class EntityView(
    var id: Long = -1,
    val name: String,
    val description: String,
    val quantity: Int,
    val price: Double,
    override val viewType: Int = ViewType.ENTITY.ordinal
) : RecyclerViewItem
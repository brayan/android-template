package br.com.sailboat.template.model

import br.com.sailboat.template.model.RecyclerViewItem
import br.com.sailboat.template.model.ViewType

data class LabelAndValueModel(
    override val viewType: Int = ViewType.LABEL_VALUE.ordinal,
    val label: String,
    val value: String
) : RecyclerViewItem
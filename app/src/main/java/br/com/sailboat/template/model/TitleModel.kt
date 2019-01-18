package br.com.sailboat.template.model

import br.com.sailboat.template.model.RecyclerViewItem

data class TitleModel(
    override val viewType: Int = ViewType.TITLE.ordinal,
    val title: String
) : RecyclerViewItem
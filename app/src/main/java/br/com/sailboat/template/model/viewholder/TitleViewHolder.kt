package br.com.sailboat.template.model.viewholder

import android.view.ViewGroup
import br.com.sailboat.template.R
import br.com.sailboat.template.base.BaseViewHolder
import br.com.sailboat.template.model.TitleModel
import kotlinx.android.synthetic.main.vh_title.view.*

class TitleViewHolder(parent: ViewGroup) :
    BaseViewHolder<TitleModel>(inflate(parent, R.layout.vh_title)) {

    override fun bindItem(item: TitleModel) {
        itemView.tvTitle.text = item.title
    }

}
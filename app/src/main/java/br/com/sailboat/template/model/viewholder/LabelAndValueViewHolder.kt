package br.com.sailboat.template.model.viewholder

import android.view.ViewGroup
import br.com.sailboat.template.R
import br.com.sailboat.template.base.BaseViewHolder
import br.com.sailboat.template.model.LabelAndValueModel
import kotlinx.android.synthetic.main.vh_label_value.view.*

class LabelAndValueViewHolder(parent: ViewGroup) :
    BaseViewHolder<LabelAndValueModel>(inflate(parent, R.layout.vh_label_value)) {

    override fun bindItem(item: LabelAndValueModel) {
        itemView.tvLabel.text = item.label
        itemView.tvValue.text = item.value
    }

}
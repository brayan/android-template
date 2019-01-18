package br.com.sailboat.template.model.viewholder

import android.support.v4.content.ContextCompat
import android.view.ViewGroup
import br.com.sailboat.template.R
import br.com.sailboat.template.base.BaseViewHolder
import br.com.sailboat.template.domain.helper.DecimalHelper
import br.com.sailboat.template.model.EntityView
import kotlinx.android.synthetic.main.vh_entity.view.*

class EntityViewHolder(parent: ViewGroup, callback: Callback) :
    BaseViewHolder<EntityView>(inflate(parent, R.layout.vh_entity)) {

    init {
        itemView.setOnClickListener { callback.onClickEntity(adapterPosition) }
    }

    override fun bindItem(item: EntityView) {
        itemView.txtName.text = item.name
        itemView.txtDescription.text = item.description
        itemView.txtQuantity.text = item.quantity.toString()
        itemView.txtPrice.text = DecimalHelper.toCurrency(item.price)
        initColorOfQuantity(item)
    }

    private fun initColorOfQuantity(item: EntityView) {
        val color = if (item.quantity == 0) {
            R.color.grey_40
        } else {
            R.color.md_teal_300
        }

        itemView.txtQuantity.setTextColor(ContextCompat.getColor(itemView.context, color))
    }


    interface Callback {
        fun onClickEntity(position: Int)
    }

}
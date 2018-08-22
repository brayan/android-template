package br.com.sailboat.template.ui.entity.details

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import br.com.sailboat.template.ui.model.LabelAndValueModel
import br.com.sailboat.template.ui.model.RecyclerViewItem
import br.com.sailboat.template.ui.model.TitleModel
import br.com.sailboat.template.ui.model.ViewType
import br.com.sailboat.template.ui.model.viewholder.LabelAndValueViewHolder
import br.com.sailboat.template.ui.model.viewholder.TitleViewHolder

class EntityDetailsAdapter(var callback: Callback) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {
            ViewType.TITLE.ordinal -> return TitleViewHolder(parent)
            ViewType.LABEL_VALUE.ordinal -> return LabelAndValueViewHolder(parent)
            else -> throw RuntimeException("ViewHolder not found")
        }

    }

    override fun getItemCount() = callback.getEntityDetails().size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = callback.getEntityDetails()[position]

        when (holder) {
            is TitleViewHolder -> holder.bindItem(item as TitleModel)
            is LabelAndValueViewHolder -> holder.bindItem(item as LabelAndValueModel)
            else -> throw RuntimeException("ViewHolder not found")
        }
    }

    override fun getItemViewType(position: Int) = callback.getEntityDetails()[position].viewType


    interface Callback {
        fun getEntityDetails(): List<RecyclerViewItem>
    }

}
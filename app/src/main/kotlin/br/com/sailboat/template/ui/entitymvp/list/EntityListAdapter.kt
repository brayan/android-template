package br.com.sailboat.template.ui.entity.list

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import br.com.sailboat.template.ui.model.EntityView
import br.com.sailboat.template.ui.model.ViewType
import br.com.sailboat.template.ui.model.viewholder.EntityViewHolder


class EntityListAdapter(val callback: EntityListAdapter.Callback) : RecyclerView.Adapter<EntityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        return when (viewType) {
            ViewType.ENTITY.ordinal -> EntityViewHolder(parent, callback)
            else -> throw RuntimeException("ViewHolder not found")
        }
    }

    override fun getItemCount() = callback.getEntities().size

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        holder.bindItem(callback.getEntities()[position])
    }


    interface Callback : EntityViewHolder.Callback {
        fun getEntities(): List<EntityView>
    }

}
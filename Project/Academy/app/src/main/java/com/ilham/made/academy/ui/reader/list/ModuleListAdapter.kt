package com.ilham.made.academy.ui.reader.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ilham.made.academy.R
import com.ilham.made.academy.data.source.local.entity.ModuleEntity

class ModuleListAdapter internal constructor(private val listener: MyAdapterClickListener) : RecyclerView.Adapter<ModuleListAdapter.ModuleViewHolder>() {
    private val listModules = ArrayList<ModuleEntity>()

    internal fun setModules(modules: List<ModuleEntity>?) {
        if (modules == null) return
        listModules.clear()
        listModules.addAll(modules)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_module_list_custom, parent, false)
        return ModuleViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ModuleViewHolder, position: Int) {
        val module = listModules[position]
        viewHolder.bind(module)
        if (viewHolder.itemViewType == 0){
            viewHolder.textModuleTitle.setTextColor(ContextCompat.getColor(viewHolder.itemView.context, R.color.colorTextSecondary))
        } else {
            viewHolder.itemView.setOnClickListener {
                listener.onItemClicked(viewHolder.adapterPosition, listModules[viewHolder.adapterPosition].moduleId)
            }
        }
    }

    override fun getItemCount(): Int = listModules.size

    override fun getItemViewType(position: Int): Int {
        val modulePosition = listModules[position].position
        return when {
            modulePosition == 0 -> 1
            listModules[modulePosition - 1].read -> 1
            else -> 0
        }
    }

    inner class ModuleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textModuleTitle: TextView = itemView.findViewById(R.id.text_module_title)
        fun bind(module: ModuleEntity) {
            textModuleTitle.text = module.title
        }
    }
}

internal interface MyAdapterClickListener {
    fun onItemClicked(position: Int, moduleId: String)
}
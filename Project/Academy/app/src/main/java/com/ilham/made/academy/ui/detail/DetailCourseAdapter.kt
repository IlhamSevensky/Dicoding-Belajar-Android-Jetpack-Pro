package com.ilham.made.academy.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilham.made.academy.R
import com.ilham.made.academy.data.source.local.entity.ModuleEntity
import kotlinx.android.synthetic.main.items_module_list.view.*

class DetailCourseAdapter : RecyclerView.Adapter<DetailCourseAdapter.ModuleViewHolder>() {

    private val listModules = ArrayList<ModuleEntity>()

    fun setModules(modules: List<ModuleEntity>?) {
        if (modules == null) return
        listModules.clear()
        listModules.addAll(modules)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_module_list, parent, false)
        return ModuleViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ModuleViewHolder, position: Int) {
        val module = listModules[position]
        viewHolder.bind(module)
    }

    override fun getItemCount(): Int = listModules.size

    inner class ModuleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(module: ModuleEntity) {
            with(itemView) {
                text_module_title.text = module.title
            }
        }
    }
}
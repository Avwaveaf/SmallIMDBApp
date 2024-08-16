package com.avwaveaf.smallimdbapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class GenericRecyclerViewAdapter<T, VB : ViewDataBinding>(
    private val itemLayoutId: Int,
    private val bind: (VB, T) -> Unit,
    private val areItemsTheSameCondition: (T, T) -> Boolean,
    private val areContentsTheSameCondition: (T, T) -> Boolean
): ListAdapter<T, GenericRecyclerViewAdapter.GenericViewHolder<VB>>(object: DiffUtil.ItemCallback<T>(){
    override fun areItemsTheSame(oldItem: T & Any, newItem: T & Any): Boolean {
        return areItemsTheSameCondition(oldItem, newItem)
    }

    override fun areContentsTheSame(oldItem: T & Any, newItem: T & Any): Boolean {
        return areContentsTheSameCondition(oldItem, newItem)
    }
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<VB> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<VB>(layoutInflater, itemLayoutId, parent, false)
        return GenericViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenericViewHolder<VB>, position: Int) {
        val item = getItem(position)
        bind(holder.binding, item)
    }


    class GenericViewHolder<VB : ViewDataBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root)


}
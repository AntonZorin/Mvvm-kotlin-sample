package com.az.kotlinsample.ui.lists

import android.support.v7.widget.RecyclerView
import android.view.View
import java.util.*

/**
 * Created by zorin.a on 14.12.2017.
 */

abstract class BaseAdapter<T1, out T2, T3 : BaseViewHolder<T2>> : RecyclerView.Adapter<T3>() where T2 : View, T2 : ViewModel<T1> {
    private var content: MutableList<T1> = ArrayList()

    override fun onBindViewHolder(holder: T3, position: Int) {
        val view: T2 = holder.view
        view.setData(content[position])
    }

    fun setData(data: List<T1>) {
        content.clear()
        content.addAll(data)
        notifyDataSetChanged()
    }

    fun getModel(position: Int): T1? =
            if (content.size - 1 >= position) content[position] else null

    fun addData(data: T1) {
        content.add(data)
        notifyItemInserted(content.size - 1)
    }

    fun getData(position: Int): T1 = content[position]

    fun insertDataToStart(data: T1) {
        content.add(0, data)
        notifyItemInserted(0)
    }

    fun addData(data: List<T1>) {
        content.addAll(data)
        notifyItemRangeInserted(content.size - 1 - data.size, data.size)
    }

    fun removeData(position: Int) {
        if (itemCount > position) {
            content.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, content.size + 1)
        }
    }

    fun clearData() {
        content.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = content.size ?: 0

}

package com.silva021.home.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.silva021.home.databinding.WidgetEmptyViewholderBinding
import com.silva021.home.databinding.WidgetHomeHeaderBinding
import com.silva021.home.domain.model.HomeHeaderWidget
import com.silva021.home.domain.model.Widget
import com.silva021.home.domain.model.Widgets
import com.silva021.home.ui.home.adapter.viewholder.EmptyViewHolder
import com.silva021.home.ui.home.adapter.viewholder.HomeHeaderVIewHolder

class HomeAdapter(private val widgetList: List<Widget>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            Widgets.HOME_HEADER.ordinal -> HomeHeaderVIewHolder(
                WidgetHomeHeaderBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            else -> EmptyViewHolder(
                WidgetEmptyViewholderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HomeHeaderVIewHolder -> holder.bind(widgetList[position] as HomeHeaderWidget)
        }

    }

    override fun getItemCount(): Int = widgetList.size

    override fun getItemViewType(position: Int) = when {
        isHomeWidget(position, Widgets.HOME_HEADER) -> Widgets.HOME_HEADER.ordinal
        else -> 999
    }

    private fun isHomeWidget(position: Int, widget: Widgets) =
        widgetList[position].identifier == widget.name
}
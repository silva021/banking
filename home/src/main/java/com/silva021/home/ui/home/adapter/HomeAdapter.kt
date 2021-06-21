package com.silva021.home.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.silva021.home.databinding.WidgetEmptyViewholderBinding
import com.silva021.home.databinding.WidgetHomeCardBinding
import com.silva021.home.databinding.WidgetHomeHeaderBinding
import com.silva021.home.databinding.WidgetHomeStatementBinding
import com.silva021.home.ui.home.adapter.viewholder.EmptyViewHolder
import com.silva021.home.ui.home.adapter.viewholder.HomeCardViewHolder
import com.silva021.home.ui.home.adapter.viewholder.HomeHeaderViewHolder
import com.silva021.home.ui.home.adapter.viewholder.HomeStatementViewHolder
import com.silva021.network.response.model.*

class HomeAdapter(private val widgetList: List<Widget>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            Widgets.HOME_HEADER_WIDGET.ordinal -> HomeHeaderViewHolder(
                WidgetHomeHeaderBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            Widgets.HOME_CARD_WIDGET.ordinal -> HomeCardViewHolder(
                WidgetHomeCardBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            Widgets.HOME_STATEMENT_WIDGET.ordinal -> HomeStatementViewHolder(
                WidgetHomeStatementBinding.inflate(
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
            is HomeHeaderViewHolder -> holder.bind(widgetList[position] as HomeHeaderWidget)
            is HomeCardViewHolder -> holder.bind(widgetList[position] as HomeCardWidget)
            is HomeStatementViewHolder -> holder.bind(widgetList[position] as HomeStatementWidget)
        }

    }

    override fun getItemCount(): Int = widgetList.size

    override fun getItemViewType(position: Int) = when {
        isHomeWidget(position, Widgets.HOME_HEADER_WIDGET) -> Widgets.HOME_HEADER_WIDGET.ordinal
        isHomeWidget(position, Widgets.HOME_CARD_WIDGET) -> Widgets.HOME_CARD_WIDGET.ordinal
        isHomeWidget(
            position,
            Widgets.HOME_STATEMENT_WIDGET
        ) -> Widgets.HOME_STATEMENT_WIDGET.ordinal
        else -> 999
    }

    private fun isHomeWidget(position: Int, widget: Widgets) =
        widgetList[position].identifier == widget.name
}
package com.silva021.network.response.model


data class HomeHeaderWidget(val content: HomeHeaderContent) : Widget(Widgets.HOME_HEADER_WIDGET.name)

data class HomeHeaderContent(
    val title: String
)

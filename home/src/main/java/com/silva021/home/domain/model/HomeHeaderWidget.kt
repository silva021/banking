package com.silva021.home.domain.model

data class HomeHeaderWidget(val content: HomeHeaderContent) : Widget(Widgets.HOME_HEADER.name)

data class HomeHeaderContent(
    val title: String
)

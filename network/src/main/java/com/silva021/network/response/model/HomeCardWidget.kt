package com.silva021.network.response.model


data class HomeCardWidget(val content: HomeCardWidgetContent) :
    Widget(Widgets.HOME_CARD_WIDGET.name)

data class HomeCardWidgetContent(
    val title: String,
    val cardNumber: String,
    val button: HomeCardWidgetButton
)

data class HomeCardWidgetButton(
    val text: String,
    val action: HomeCardWidgetButtonAction
)

data class HomeCardWidgetButtonAction(
    val identifier: String,
    val content: HomeCardWidgetButtonContent
)

data class HomeCardWidgetButtonContent(val cardId: String)
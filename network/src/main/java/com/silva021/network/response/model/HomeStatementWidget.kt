package com.silva021.network.response.model

data class HomeStatementWidget(val content: HomeStatementWidgetContent) :
    Widget(Widgets.HOME_STATEMENT_WIDGET.name)

data class HomeStatementWidgetContent(
    val title: String,
    val balance: Balance,
    val button: HomeStatementWidgetButton
)

data class Balance(
    val label: String,
    val value: String
)


data class HomeStatementWidgetButton(
    val text: String,
    val action: HomeStatementWidgetButtonAction
)

data class HomeStatementWidgetButtonAction(
    val identifier: String,
    val content: HomeStatementWidgetButtonContent
)

data class HomeStatementWidgetButtonContent(val accountId: String)
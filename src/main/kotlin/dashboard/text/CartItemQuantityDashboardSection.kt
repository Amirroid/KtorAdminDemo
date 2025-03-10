package ir.amirreza.dashboard.text

import dashboard.simple.TextDashboardSection
import models.chart.TextDashboardAggregationFunction

class CartItemQuantityDashboardSection : TextDashboardSection() {
    override val tableName: String
        get() = "cartitem"
    override val fieldName: String
        get() = "quantity"
    override val hintText: String
        get() = "The sum of cart quantities"
    override val aggregationFunction: TextDashboardAggregationFunction
        get() = TextDashboardAggregationFunction.SUM
    override val sectionName: String
        get() = "Cart Item count"
    override val index: Int
        get() = 2
}
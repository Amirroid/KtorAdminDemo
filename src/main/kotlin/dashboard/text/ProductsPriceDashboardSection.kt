package ir.amirreza.dashboard.text

import dashboard.simple.TextDashboardSection
import models.chart.TextDashboardAggregationFunction

class ProductsPriceDashboardSection : TextDashboardSection() {
    override val tableName: String
        get() = "product"
    override val fieldName: String
        get() = "price"
    override val hintText: String
        get() = "The average of all products"
    override val aggregationFunction: TextDashboardAggregationFunction
        get() = TextDashboardAggregationFunction.AVERAGE
    override val sectionName: String
        get() = "Price AVG"
    override val index: Int
        get() = 3
}
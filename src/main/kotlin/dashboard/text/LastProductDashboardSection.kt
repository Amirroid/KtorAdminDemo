package ir.amirreza.dashboard.text

import dashboard.simple.TextDashboardSection
import models.chart.TextDashboardAggregationFunction

class LastProductDashboardSection : TextDashboardSection() {
    override val tableName: String
        get() = "product"
    override val fieldName: String
        get() = "name"
    override val hintText: String
        get() = "The last added product"
    override val aggregationFunction: TextDashboardAggregationFunction
        get() = TextDashboardAggregationFunction.LAST_ITEM
    override val sectionName: String
        get() = "Price LAST"

    override val orderQuery: String?
        get() = "id DESC"

    override val index: Int
        get() = 4
}
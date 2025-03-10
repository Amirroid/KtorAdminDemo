package ir.amirreza.dashboard.text

import dashboard.simple.TextDashboardSection
import models.chart.TextDashboardAggregationFunction

class UserCountDashboardSection : TextDashboardSection() {
    override val tableName: String
        get() = "users"
    override val fieldName: String
        get() = "id"
    override val hintText: String
        get() = "The count of users"
    override val aggregationFunction: TextDashboardAggregationFunction
        get() = TextDashboardAggregationFunction.COUNT
    override val sectionName: String
        get() = "User count"
    override val index: Int
        get() = 1
}
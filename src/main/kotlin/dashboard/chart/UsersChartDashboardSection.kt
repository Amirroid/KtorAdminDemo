package ir.amirreza.dashboard.chart

import dashboard.chart.ChartDashboardSection
import ir.amirreza.data.models.profile.UserRole
import models.chart.AdminChartStyle
import models.chart.ChartDashboardAggregationFunction
import models.chart.ChartField

class UsersChartDashboardSection : ChartDashboardSection() {
    override val aggregationFunction: ChartDashboardAggregationFunction
        get() = ChartDashboardAggregationFunction.COUNT
    override val tableName: String
        get() = "users"
    override val labelField: String
        get() = "role"
    override val valuesFields: List<ChartField>
        get() = listOf(
            ChartField(
                "id"
            )
        )
    override val chartStyle: AdminChartStyle
        get() = AdminChartStyle.PIE

    override fun provideBorderColor(label: String, valueField: String): String? {
        return null
    }

    override fun provideFillColor(label: String, valueField: String): String? {
        return when (label) {
            UserRole.CUSTOMER.name -> "blue"
            UserRole.BUYER.name -> "red"
            else -> "green"
        }
    }

    override val borderWidth: Float
        get() = 2f

    override val sectionName: String
        get() = "User roles"
    override val index: Int
        get() = 7
}
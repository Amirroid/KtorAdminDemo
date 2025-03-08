package ir.amirreza.dashboard.chart

import dashboard.chart.ChartDashboardSection
import models.chart.AdminChartStyle
import models.chart.ChartDashboardAggregationFunction
import models.chart.ChartField

class ProductsChartDashboardSection : ChartDashboardSection() {
    override val aggregationFunction: ChartDashboardAggregationFunction
        get() = ChartDashboardAggregationFunction.ALL
    override val tableName: String
        get() = "product"
    override val labelField: String
        get() = "created_at"
    override val valuesFields: List<ChartField>
        get() = listOf(
            ChartField(
                "price"
            )
        )
    override val chartStyle: AdminChartStyle
        get() = AdminChartStyle.LINE


    override fun provideBorderColor(label: String, valueField: String): String? {
        return "black"
    }

    override fun provideFillColor(label: String, valueField: String): String? {
        return "wheat"
    }


    override val tension: Float
        get() = .4f

    override val sectionName: String
        get() = "Products prices"
    override val index: Int
        get() = 5
}
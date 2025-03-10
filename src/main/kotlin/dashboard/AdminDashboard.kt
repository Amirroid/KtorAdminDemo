package ir.amirreza.dashboard

import dashboard.KtorAdminDashboard
import ir.amirreza.dashboard.chart.ProductsChartDashboardSection
import ir.amirreza.dashboard.chart.UsersChartDashboardSection
import ir.amirreza.dashboard.list.ProductsListDashboardSection
import ir.amirreza.dashboard.text.CartItemQuantityDashboardSection
import ir.amirreza.dashboard.text.LastProductDashboardSection
import ir.amirreza.dashboard.text.ProductsPriceDashboardSection
import ir.amirreza.dashboard.text.UserCountDashboardSection

class AdminDashboard : KtorAdminDashboard() {
    override fun KtorAdminDashboard.configure() {
        configureLayout {
            addSection(section = UserCountDashboardSection(), height = TEXT_SECTION_HEIGHT)
            addSection(section = CartItemQuantityDashboardSection(), height = TEXT_SECTION_HEIGHT)
            addSection(section = ProductsPriceDashboardSection(), height = TEXT_SECTION_HEIGHT)
            addSection(section = LastProductDashboardSection(), height = TEXT_SECTION_HEIGHT)
            addSection(section = ProductsChartDashboardSection(), span = 4)
            addSection(section = ProductsListDashboardSection(), span = 2)
            addSection(section = UsersChartDashboardSection(), span = 2)
//            addSection(section = ProductsChartDashboardSection(), span = 2)
        }
    }

    companion object {
        private const val TEXT_SECTION_HEIGHT = "200px"
    }
}
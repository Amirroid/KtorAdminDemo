package ir.amirreza.dashboard.list

import dashboard.list.ListDashboardSection

class ProductsListDashboardSection : ListDashboardSection() {
    override val tableName: String
        get() = "product"
    override val sectionName: String
        get() = "Products"
    override val limitCount: Int?
        get() = 10
    override val index: Int
        get() = 6
}
package ir.amirreza.data.models.cart

import annotations.exposed.ExposedTable
import annotations.info.ColumnInfo
import annotations.info.IgnoreColumn
import annotations.references.ManyToOneReferences
import ir.amirreza.data.models.products.Product
import org.jetbrains.exposed.sql.Table

@ExposedTable(
    "cartitem",
    "id",
    singularName = "Cart Item",
    pluralName = "Cart Items",
    groupName = "Cart"
)
object CartItem : Table() {
    @IgnoreColumn
    val id = integer("id").autoIncrement()

    @ColumnInfo("cart_id", verboseName = "Cart")
    @ManyToOneReferences("cart", "id")
    val cartId = integer("cart_id").references(Cart.id)

    @ColumnInfo("product_id", verboseName = "Product")
    @ManyToOneReferences("product", "id")
    val productId = integer("product_id").references(Product.id)

    @ColumnInfo(defaultValue = "1")
    val quantity = integer("quantity").default(1)

    override val primaryKey = PrimaryKey(id)
}

package ir.amirreza.data.models.cart

import annotations.exposed.ExposedTable
import annotations.info.ColumnInfo
import annotations.info.IgnoreColumn
import ir.amirreza.data.models.profile.Users
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

@ExposedTable("cart", "id", groupName = "Cart")
object Cart : Table() {
    @IgnoreColumn
    val id = integer("id").autoIncrement()

    @ColumnInfo("user_id")
    val userId = integer("user_id").references(Users.id, onDelete = ReferenceOption.CASCADE)

    override val primaryKey = PrimaryKey(id)
}
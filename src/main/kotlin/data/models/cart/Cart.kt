package ir.amirreza.data.models.cart

import annotations.display.DisplayFormat
import annotations.exposed.ExposedTable
import annotations.info.ColumnInfo
import annotations.info.IgnoreColumn
import annotations.query.AdminQueries
import annotations.references.ManyToOneReferences
import annotations.references.OneToOneReferences
import ir.amirreza.data.models.profile.Users
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table

@ExposedTable("cart", "id", groupName = "Cart")
@AdminQueries(
    searches = ["user_id.full_name"]
)
@DisplayFormat(
    format = "User: {user_id.full_name}",
)
object Cart : Table() {
    @IgnoreColumn
    val id = integer("id").autoIncrement()

    @ColumnInfo("user_id", verboseName = "User")
    @OneToOneReferences("users", "id")
    val userId = integer("user_id").references(Users.id, onDelete = ReferenceOption.CASCADE)

    override val primaryKey = PrimaryKey(id)
}
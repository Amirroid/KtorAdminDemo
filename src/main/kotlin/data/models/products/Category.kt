package ir.amirreza.data.models.products

import annotations.exposed.ExposedTable
import annotations.info.IgnoreColumn
import annotations.query.AdminQueries
import annotations.text_area.TextAreaField
import org.jetbrains.exposed.sql.Table

@ExposedTable(
    tableName = "category",
    primaryKey = "id",
    singularName = "Category",
    pluralName = "Categories",
    groupName = "Products"
)
@AdminQueries(
    searches = ["name", "description"],
)
object Category : Table() {
    @IgnoreColumn
    val id = integer("id").autoIncrement()
    val name = varchar("name", 100).uniqueIndex()

    @TextAreaField
    val description = text("description").nullable()

    override val primaryKey = PrimaryKey(id)
}
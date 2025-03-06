package ir.amirreza.data.models.products

import annotations.exposed.ExposedTable
import annotations.info.ColumnInfo
import annotations.info.IgnoreColumn
import annotations.query.AdminQueries
import annotations.references.ManyToOneReferences
import annotations.rich_editor.RichEditor
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
    filters = ["parent_category_id"]
)
object Category : Table() {
    @IgnoreColumn
    val id = integer("id").autoIncrement()
    val name = varchar("name", 100).uniqueIndex()

    @TextAreaField
    val description = text("description").nullable()

    @ColumnInfo("parent_category_id", nullable = true, verboseName = "Parent category")
    @ManyToOneReferences("category", "id")
    val parentCategoryId = integer("parent_category_id").references(id).nullable()

    override val primaryKey = PrimaryKey(id)
}
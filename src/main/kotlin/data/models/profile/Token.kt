package ir.amirreza.data.models.profile

import annotations.display.DisplayFormat
import annotations.exposed.ExposedTable
import annotations.info.ColumnInfo
import annotations.limit.Limits
import annotations.query.AdminQueries
import annotations.references.OneToOneReferences
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

@ExposedTable(
    tableName = "token",
    primaryKey = "user_id",
    singularName = "token",
    pluralName = "tokens",
    groupName = "Profiles"
)
@AdminQueries(
    searches = ["user_id.full_name"],
    filters = ["expired_at"]
)
object TokenTable : Table() {
    @ColumnInfo("user_id", verboseName = "User")
    @OneToOneReferences("users", "id")
    val userId = integer("user_id").references(Users.id, onDelete = ReferenceOption.CASCADE)

    val token = text("token")

    @ColumnInfo("expired_at")
    @Limits(
        minDateRelativeToNow = 0
    )
    val expiredAt = datetime("expired_at")
    override val primaryKey = PrimaryKey(userId)
}
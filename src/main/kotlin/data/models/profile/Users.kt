package ir.amirreza.data.models.profile

import annotations.confirmation.Confirmation
import annotations.date.AutoNowDate
import annotations.display.DisplayFormat
import annotations.display.PanelDisplayList
import annotations.enumeration.Enumeration
import annotations.exposed.ExposedTable
import annotations.info.ColumnInfo
import annotations.info.IgnoreColumn
import annotations.limit.Limits
import annotations.query.AdminQueries
import annotations.status.StatusStyle
import annotations.text_area.TextAreaField
import annotations.value_mapper.ValueMapper
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.CurrentDateTime
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

enum class UserRole { ADMIN, CUSTOMER, BUYER }

@ExposedTable(
    "users",
    "id",
    groupName = "Profiles",
    singularName = "User",
    pluralName = "Users",
)
@AdminQueries(
    searches = ["username", "email", "phone_number"],
    filters = ["role"]
)
@DisplayFormat("{id}: {full_name}")
@PanelDisplayList("username", "phone_number", "created_at", "role")
object Users : Table() {
    @IgnoreColumn
    val id = integer("id").autoIncrement()

    @ColumnInfo(unique = true)
    val username = varchar("username", 100).uniqueIndex()

    @ColumnInfo(unique = true)
    @Limits(
        maxLength = 100,
        regexPattern = """[A-z0-9]*@[A-z0-9]*.[A-z0-9]*"""
    )
    val email = varchar("email", 100).uniqueIndex()

    @ColumnInfo("password_hash", verboseName = "Password")
    @Limits(maxLength = 255)
    @Confirmation
    @ValueMapper("password")
    val passwordHash = varchar("password_hash", 255)

    @Limits(maxLength = 255)
    @ColumnInfo("full_name")
    val fullName = varchar("full_name", 255).nullable()

    @TextAreaField
    val address = text("address").nullable()

    @ColumnInfo("phone_number")
    @Limits(maxLength = 20)
    val phoneNumber = varchar("phone_number", 20).nullable()

    @Enumeration("ADMIN", "CUSTOMER", "BUYER")
    @StatusStyle("#D32F2F", "#1976D2", "#388E3C")
    val role = enumerationByName("role", 50, UserRole::class)

    @ColumnInfo("created_at", verboseName = "Created at")
    @AutoNowDate
    val createdAt = datetime("created_at").defaultExpression(CurrentDateTime)

    @ColumnInfo("updated_at")
    @AutoNowDate(updateOnChange = true)
    val updatedAt = datetime("updated_at").defaultExpression(CurrentDateTime)

    override val primaryKey = PrimaryKey(id)
}
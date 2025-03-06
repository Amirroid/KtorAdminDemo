package ir.amirreza.data.services

import ir.amirreza.data.models.products.Category
import ir.amirreza.data.models.profile.Users
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class DatabasesService(database: Database) {
    init {
        transaction(database) {
            SchemaUtils.create(Users)
            SchemaUtils.create(Category)
        }
    }
}
package ir.amirreza.data.services

import ir.amirreza.data.models.cart.Cart
import ir.amirreza.data.models.cart.CartItem
import ir.amirreza.data.models.products.Category
import ir.amirreza.data.models.products.Product
import ir.amirreza.data.models.profile.TokenTable
import ir.amirreza.data.models.profile.Users
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class DatabasesService(database: Database) {
    init {
        transaction(database) {
            SchemaUtils.create(Users)
            SchemaUtils.create(Category)
            SchemaUtils.create(Product)
            SchemaUtils.create(Cart)
            SchemaUtils.create(CartItem)
        }
    }
}
package ir.amirreza

import io.ktor.server.application.*
import ir.amirreza.data.services.DatabasesService
import org.jetbrains.exposed.sql.Database

fun Application.configureDatabases(database: Database) {
    val services = DatabasesService(database)
}

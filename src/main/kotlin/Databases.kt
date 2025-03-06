package ir.amirreza

import io.ktor.server.application.*
import ir.amirreza.data.services.DatabasesService
import org.jetbrains.exposed.sql.Database

fun Application.configureDatabases() {
    val database = Database.connect(
        url = environment.config.property("db.url").getString(),
        user = environment.config.property("db.username").getString(),
        driver = environment.config.property("db.driver").getString(),
        password = environment.config.property("db.password").getString(),
    )
    val services = DatabasesService(database)
}

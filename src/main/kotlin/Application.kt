package ir.amirreza

import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val database = getDatabase()
    configureSerialization()
    configureDatabases(database)
    configureRouting()
    configureSecurity(database)
    configureAdmin()
}

private fun Application.getDatabase() = Database.connect(
    url = environment.config.property("db.url").getString(),
    user = environment.config.property("db.username").getString(),
    driver = environment.config.property("db.driver").getString(),
    password = environment.config.property("db.password").getString(),
)
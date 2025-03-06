package ir.amirreza

import io.ktor.server.application.Application
import io.ktor.server.application.install
import plugins.KtorAdmin

fun Application.configureAdmin() {
    install(KtorAdmin) {
        jdbc(
            key = null,
            url = environment.config.property("db.url").getString(),
            username = environment.config.property("db.username").getString(),
            driver = environment.config.property("db.driver").getString(),
            password = environment.config.property("db.password").getString(),
        )
    }
}
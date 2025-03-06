package ir.amirreza

import authentication.ktorAdminTokenAuth
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.auth.Authentication
import ir.amirreza.data.services.TokenService
import models.forms.LoginFiled
import org.jetbrains.exposed.sql.Database

fun Application.configureSecurity(database: Database) {
    val tokenService = TokenService(database)
    install(Authentication) {
        ktorAdminTokenAuth("admin") {
            validateForm { credentials ->
                tokenService.getTokenWithUsernameAndPassword(
                    credentials["username"] ?: return@validateForm null,
                    credentials["password"] ?: return@validateForm null,
                )
            }

            validateToken { token ->
                tokenService.getUserPrincipalWithToken(token)
            }
        }
    }
}

val loginFields = listOf(
    LoginFiled(
        "username",
        "username",
        autoComplete = "username"
    ),
    LoginFiled(
        "password",
        "password",
        type = "password",
        autoComplete = "password"
    ),
)
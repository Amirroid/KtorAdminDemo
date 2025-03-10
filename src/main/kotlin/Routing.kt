package ir.amirreza

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

fun Application.configureRouting() {
    routing {
        staticFiles("/$MEDIA_ROOT", File(MEDIA_PATH))
        get("/") {
            call.respondText("Hello World!")
        }
    }
}

package ir.amirreza

import io.ktor.server.application.*
import ir.amirreza.dashboard.AdminDashboard
import ir.amirreza.data.value_mapper.PasswordValueMapper
import ir.amirreza.preview.ImagePreview
import models.menu.Menu
import plugins.KtorAdmin

const val MEDIA_PATH = "uploads"
const val MEDIA_ROOT = "uploads"

fun Application.configureAdmin() {
    install(KtorAdmin) {
        jdbc(
            key = null,
            url = environment.config.property("db.url").getString(),
            username = environment.config.property("db.username").getString(),
            driver = environment.config.property("db.driver").getString(),
            password = environment.config.property("db.password").getString(),
        )
        mediaPath = MEDIA_PATH
        mediaRoot = MEDIA_ROOT
        adminDashboard = AdminDashboard()
        authenticateName = "admin"
        loginFields = ir.amirreza.loginFields
        loginPageMessage =
            "Enter <strong  class=\"istok-web-black\">admin</strong> as username and <strong class=\"istok-web-black\">password</strong> as password."
        registerValueMapper(PasswordValueMapper)
        registerPreview(ImagePreview)
        provideMenu { menuItems }
        maxItemsInPage = 10
    }
}

val menuItems = listOf(
    Menu(
        title = "Github",
        link = "https://github.com/Amirroid"
    )
)
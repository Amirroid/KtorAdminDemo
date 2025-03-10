package ir.amirreza.data.services

import authentication.KtorAdminPrincipal
import ir.amirreza.data.crypto.PasswordHasher
import ir.amirreza.data.models.profile.TokenTable
import ir.amirreza.data.models.profile.UserRole
import ir.amirreza.data.models.profile.Users
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

class TokenService(val database: Database) {
    init {
        transaction(database) {
            SchemaUtils.create(TokenTable)
        }
    }


    suspend fun getTokenWithUsernameAndPassword(username: String, password: String): String? = dbQuery {
        val user = Users.selectAll()
            .where { Users.username eq username }
            .firstOrNull()

        val storedHash = user?.get(Users.passwordHash)

        if (storedHash != null && PasswordHasher.verify(password, storedHash)) {
            val userId = user[Users.id]
            TokenTable.selectAll().where { TokenTable.userId eq userId }
                .firstOrNull()?.get(TokenTable.token)
        } else {
            null
        }
    }

    suspend fun getUserPrincipalWithToken(token: String): KtorAdminPrincipal? = dbQuery {
        val userId = TokenTable.selectAll().where { TokenTable.token eq token }.firstOrNull()?.get(TokenTable.userId)
        userId?.let { id ->
            Users.selectAll().where { Users.id eq userId }.firstOrNull()?.let {
                if (it[Users.role] == UserRole.ADMIN) {
                    KtorAdminPrincipal(
                        name = it[Users.fullName] ?: "",
                    )
                } else null
            }
        }
    }
}


suspend fun <T> dbQuery(block: suspend () -> T): T =
    newSuspendedTransaction(Dispatchers.IO) { block() }
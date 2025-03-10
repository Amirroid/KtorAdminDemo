package ir.amirreza.data.value_mapper

import ir.amirreza.data.crypto.PasswordHasher
import mapper.KtorAdminValueMapper

object PasswordValueMapper : KtorAdminValueMapper {
    override val key: String
        get() = "password"

    override fun map(value: Any?): Any? {
        return value?.let { PasswordHasher.hash(it.toString()) }
    }

    override fun restore(value: Any?): Any? {
        return value
    }
}
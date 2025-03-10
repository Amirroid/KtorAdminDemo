package ir.amirreza.preview

import preview.KtorAdminPreview

object ImagePreview : KtorAdminPreview() {
    override val key: String
        get() = "image"

    override fun createPreview(tableName: String, name: String, value: Any?): String? {
        return value?.toString()?.let { image ->
            expandable("Image Preview") {
                image(image)
            }
        }
    }
}
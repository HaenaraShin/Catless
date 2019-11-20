package dev.haenara.catless.model

data class Cat(
    val id: String,
    val url: String,
    val width: Int,
    val height: Int
) {
    override fun equals(other: Any?): Boolean {
        return if (other is Cat?) {
            other?.id == id
        } else {
            false
        }
    }
}

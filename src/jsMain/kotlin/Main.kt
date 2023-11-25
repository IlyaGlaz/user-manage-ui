import kotlinx.browser.document
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import react.create
import react.dom.client.createRoot

fun main() {
    val container = document.getElementById("root") ?: error("Couldn't find root container!")
    createRoot(container).render(App.create())
}

@Serializable
data class User(
    val id: Long,
    val username: String,
    val birthDate: LocalDate,
    val firstname: String,
    val lastname: String
)

val allUsers = listOf(
    User(1, "ivan@gmail.com", LocalDate(1900, 1, 1), "Ivan", "Ivanov"),
    User(2, "patay@gmail.com", LocalDate(1920, 2, 2), "Petya", "Smirnov"),
    User(3, "max@gmail.com", LocalDate(1988, 3, 3), "Maksim", "Maksimov")
)
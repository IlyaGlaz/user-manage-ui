import kotlinx.browser.document
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable
import react.create
import react.dom.client.createRoot
import kotlin.random.Random

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

val random: Random = Random
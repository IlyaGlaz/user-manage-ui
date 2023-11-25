import csstype.BoxSizing
import csstype.Display
import csstype.JustifyContent
import csstype.px
import emotion.react.Global
import emotion.react.css
import emotion.react.styles
import kotlinx.datetime.LocalDate
import minor.CreateButton
import minor.UserInput
import react.FC
import react.Props
import react.dom.html.InputType
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.form
import react.useState

val App = FC<Props> {
    var allUsers: List<User> by useState(
        listOf(
            User(1, "ivan@gmail.com", LocalDate(1900, 1, 1), "Ivan", "Ivanov"),
            User(2, "patay@gmail.com", LocalDate(1920, 2, 2), "Petya", "Smirnov"),
            User(3, "max@gmail.com", LocalDate(1988, 3, 3), "Maksim", "Maksimov")
        )
    )
    var username: String by useState("")
    var firstname: String by useState("")
    var lastname: String by useState("")

    val create: (Unit) -> Unit = {
        val newUser = User(
            random.nextLong(20),
            username,
            LocalDate(2010, 1, 1),
            firstname,
            lastname
        )
        allUsers = allUsers + newUser
    }

    Global {
        styles {
            "*" {
                margin = 0.px
                padding = 0.px
                boxSizing = BoxSizing.borderBox
            }

            "#root" {
                display = Display.flex
                justifyContent = JustifyContent.center
            }
        }
    }
    div {
        css {
            width = 800.px
        }
        form {
            UserInput {
                value = username
                onChangeValue = {username += value}
                type = InputType.text
                placeholder = "username"
            }
            UserInput {
                value = firstname
                onChangeValue = {firstname += value}
                type = InputType.text
                placeholder = "firstname"
            }
            UserInput {
                value = lastname
                onChangeValue = {lastname += value}
                type = InputType.text
                placeholder = "lastname"
            }
            CreateButton {
                onClickButton = create
                text = "Добавить пользователя"
            }
        }
        UserList {
            users = allUsers
        }
    }
}

import api.getAllUsers
import csstype.*
import emotion.react.Global
import emotion.react.css
import emotion.react.styles
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDate
import ui.UserInput
import react.FC
import react.Props
import react.dom.html.InputType
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.form
import react.useEffectOnce
import react.useState

val mainScope = MainScope()

val App = FC<Props> {
    var allUsers: List<User> by useState(emptyList())
    var username: String by useState("")
    var firstname: String by useState("")
    var lastname: String by useState("")

    useEffectOnce {
        mainScope.launch {
            allUsers = getAllUsers()
        }
    }

    fun create() {
        val newUser = User(
            random.nextLong(20),
            username,
            LocalDate(2010, 1, 1),
            firstname,
            lastname
        )
        allUsers = allUsers + newUser
        username = ""
        firstname = ""
        lastname = ""
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
                text = username
                onChangeValue = { username = it }
                type = InputType.text
                placeholder = "username"
            }
            UserInput {
                text = firstname
                onChangeValue = { firstname = it }
                type = InputType.text
                placeholder = "firstname"
            }
            UserInput {
                text = lastname
                onChangeValue = { lastname = it }
                type = InputType.text
                placeholder = "lastname"
            }
            button {
                css {
                    padding = Padding(5.px, 15.px)
                    color = NamedColor.teal
                    fontSize = 14.px
                    backgroundColor = NamedColor.transparent
                    border = Border(1.px, LineStyle.solid, NamedColor.teal)
                }
                onClick = { event ->
                    event.preventDefault()
                    create()
                }
                +"Добавить пользователя"
            }
        }
        UserList {
            users = allUsers
        }
    }
}

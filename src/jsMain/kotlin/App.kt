import csstype.BoxSizing
import csstype.Display
import csstype.JustifyContent
import csstype.px
import emotion.react.Global
import emotion.react.css
import emotion.react.styles
import minor.CreateButton
import minor.UserInput
import react.FC
import react.Props
import react.dom.html.InputType
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.form

val App = FC<Props> {
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
                type = InputType.text
                placeholder = "username"
            }
            UserInput {
                type = InputType.date
                placeholder = "birthDate"
            }
            UserInput {
                type = InputType.text
                placeholder = "firstname"
            }
            UserInput {
                type = InputType.text
                placeholder = "lastname"
            }
            CreateButton {
                text = "Добавить пользователя"
            }
        }
        UserList {
            users = allUsers
        }
    }
}

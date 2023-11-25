import csstype.*
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.strong

external interface UserListProps : Props {
    var users: List<User>
}

val UserList = FC<UserListProps> { props ->
    for (user in props.users) {
        div {
            css {
                display = Display.flex
                padding = 15.px
                border = Border(2.px, LineStyle.solid, NamedColor.teal)
                marginTop = 15.px
                justifyContent = JustifyContent.spaceBetween
                alignItems = AlignItems.center
            }
            div {
                strong { +"${user.id} - ${user.username}" }
                div {
                    +"${user.firstname} ${user.lastname}"
                }
                div {
                    +"${user.birthDate}"
                }
            }
            div {
                button {
                    +"Удалить"
                }
            }
        }
    }
}

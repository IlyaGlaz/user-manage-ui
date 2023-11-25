import csstype.BoxSizing
import csstype.Display
import csstype.JustifyContent
import csstype.px
import emotion.react.Global
import emotion.react.css
import emotion.react.styles
import react.FC
import react.Props
import react.dom.html.ReactHTML.div

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
        UserList {
            users = allUsers
        }
    }
}
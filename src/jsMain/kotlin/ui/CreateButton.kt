package ui

import csstype.*
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.button

external interface ButtonProps : Props {
    var onClickButton: (Unit) -> (Unit)
    var text: String
}

val CreateButton = FC<ButtonProps> { props ->
    button {
        onClick = {event ->
            event.preventDefault()
            props.onClickButton
        }
        css {
            padding = Padding(5.px, 15.px)
            color = NamedColor.teal
            fontSize = 14.px
            backgroundColor = NamedColor.transparent
            border = Border(1.px, LineStyle.solid, NamedColor.teal)
        }
        +props.text
    }
}

package minor

import csstype.*
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.InputType
import react.dom.html.ReactHTML.input

external interface InputProps : Props {
    var text: String
    var onChangeValue: (String) -> Unit
    var type: InputType
    var placeholder: String
}

val UserInput = FC<InputProps> { props ->
    input {
        css {
            width = 100.pct
            padding = Padding(5.px, 15.px)
            margin = Margin(5.px, 0.px)
            border = Border(1.px, LineStyle.solid, NamedColor.teal)
        }
        value = props.text
        onChange = { event ->
            props.onChangeValue(event.target.value)
        }
        type = props.type
        placeholder = props.placeholder
    }
}

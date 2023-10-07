package ui.lectures.javafx.mvc.propertiesmvc.view

import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import javafx.scene.control.Label
import ui.lectures.javafx.mvc.propertiesmvc.model.Model

/**
 * DoubleLabel displays the current and the previous value of the [Model][ui.lectures.javafx.mvc.propertiesmvc.model.Model] on a label.
 */
class ExtendedDoubleLabel(model: Model) : Label(), ChangeListener<Number> {

    init {
        model.MyValue.addListener(this) // listen to the Property
        changed(null, null, model.MyValue.value) // call to set initial text
    }

    override fun changed(observable: ObservableValue<out Number>?, oldValue: Number?, newValue: Number) {
        text = "The current value is: $newValue; the previous was: ${oldValue ?: "n/a"}" // set text of label if notified by the Property
    }
}
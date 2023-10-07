package ui.lectures.javafx.mvc.javafxmvcextended.view

import javafx.beans.InvalidationListener
import javafx.beans.Observable
import javafx.scene.control.Label
import ui.lectures.javafx.mvc.javafxmvcextended.model.Model

/**
 * DoubleLabel displays the value of the [Model][ui.lectures.javafx.mvc.javafxmvcextended.model.Model] on a label.
 */
class DoubleLabel(private val model: Model) : Label(), InvalidationListener {

    init {
        model.addListener(this) // subscribe to the Model
        invalidated(null) // call to set initial text
    }

    override fun invalidated(observable: Observable?) {
        text = "The current value is: ${model.getValue()}" // set text of label if notified by the Model
    }

}
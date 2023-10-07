package ui.lectures.javafx.mvc.mvcbasic.view

import javafx.scene.control.Label
import ui.lectures.javafx.mvc.mvcbasic.model.Model

/**
 * DoubleLabel displays the value of the [Model][ui.lectures.javafx.mvc.mvcbasic.model.Model] on a label.
 */
class DoubleLabel(private val model: Model) : Label(), View {

    init {
        model.addView(this) // subscribe to the Model
        update() // call my update method to set the initial text
    }

    override fun update() {
        text = "The current value is: ${model.getValue()}" // set text of label if notified by the Model
    }
}
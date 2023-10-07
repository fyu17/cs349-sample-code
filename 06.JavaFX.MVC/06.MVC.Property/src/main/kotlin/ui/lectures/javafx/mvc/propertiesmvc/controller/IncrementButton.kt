package ui.lectures.javafx.mvc.propertiesmvc.controller

import javafx.event.EventHandler
import javafx.scene.control.Button
import ui.lectures.javafx.mvc.propertiesmvc.model.Model

/**
 * Activating the IncrementButton increments the value of the [Model][ui.lectures.javafx.mvc.propertiesmvc.model.Model].
 */
class IncrementButton(private val model: Model): Button("Increment") {

    init {
        onAction = EventHandler {
            model.incrementValue()
        }
    }
}
package ui.lectures.javafx.mvc.javafxmvc.controller

import javafx.event.EventHandler
import javafx.scene.control.Button
import ui.lectures.javafx.mvc.javafxmvc.model.Model

/**
 * Activating the ResetButton resets the value of the [Model][ui.lectures.javafx.mvc.javafxmvc.model.Model].
 */
class ResetButton(private val model: Model): Button("Reset") {

    init {
        onAction = EventHandler {
            model.reset()
        }
    }
}
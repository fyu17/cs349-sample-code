package ui.lectures.javafx.mvc.javafxmvcextended.controller

import javafx.event.EventHandler
import javafx.scene.control.Button
import ui.lectures.javafx.mvc.javafxmvcextended.model.Model

/**
 * Activating the ResetValueButton resets the value of the [Model][ui.lectures.javafx.mvc.javafxmvcextended.model.Model].
 */
class ResetValueButton(private val model: Model): Button("Reset Value") {

    init {
        onAction = EventHandler {
            model.resetValue()
        }
    }
}
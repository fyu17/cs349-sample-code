package ui.lectures.javafx.mvc.javafxmvcextended.controller

import javafx.event.EventHandler
import javafx.scene.control.Button
import ui.lectures.javafx.mvc.javafxmvcextended.model.Model

/**
 * Activating the ResetListButton resets the list of the [Model][ui.lectures.javafx.mvc.javafxmvcextended.model.Model].
 */
class ResetListButton(private val model: Model): Button("Reset List") {

    init {
        onAction = EventHandler {
            model.resetList()
        }
    }
}
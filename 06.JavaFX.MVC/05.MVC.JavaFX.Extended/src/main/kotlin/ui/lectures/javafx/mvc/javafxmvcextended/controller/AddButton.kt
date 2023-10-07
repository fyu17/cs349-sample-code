package ui.lectures.javafx.mvc.javafxmvcextended.controller

import javafx.event.EventHandler
import javafx.scene.control.Button
import ui.lectures.javafx.mvc.javafxmvcextended.model.Model

/**
 * AddButton adds the next element to the list of the [Model][ui.lectures.javafx.mvc.javafxmvcextended.model.Model].
 */
class AddButton(private val model: Model): Button("Add to List") {

    init {
        onAction = EventHandler {
            model.addToList()
        }
    }
}
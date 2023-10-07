package ui.lectures.undoredo.forward.view

import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import ui.lectures.undoredo.forward.viewmodel.BalanceViewModel

/**
 * BalanceView displays the value of the [Model][ui.lectures.undoredo.forward.model.Model] and allows for modifying the value.
 */
class BalanceView(viewModel: BalanceViewModel) : VBox() {

    init {
        children.addAll(
            Label().apply {
                textProperty().bind(viewModel.balanceProperty)
            },
            Button("Increment Balance").apply {
                onAction = EventHandler {
                    viewModel.incrementBalance()
                }
            },
            Button("Reset Balance").apply {
                onAction = EventHandler {
                    viewModel.resetBalance()
                }
            },
            Button("Undo").apply {
                onAction = EventHandler {
                    viewModel.undo()
                }
            },
            Button("Redo").apply {
                onAction = EventHandler {
                    viewModel.redo()
                }
            })
        alignment = Pos.CENTER
        spacing = 10.0
    }
}

package ui.lectures.undoredo.forward.viewmodel

import javafx.beans.binding.Bindings
import javafx.beans.property.SimpleStringProperty
import ui.lectures.undoredo.forward.model.Model

class BalanceViewModel(private val model: Model) {

    /**
     * A string-representation of the current value of the [Model][ui.lectures.undoredo.forward.model.Model]
     */
    val balanceProperty = SimpleStringProperty()

    init {
        balanceProperty.bind(Bindings.createStringBinding(
            { "$ ${model.balanceProperty.value / 100}." +
              "${model.balanceProperty.value % 100 / 10}" +
              "${model.balanceProperty.value % 10}" },
            model.balanceProperty)
        )
    }

    /**
     * Attempts to increment the value of the [Model][ui.lectures.undoredo.forward.model.Model] by one.
     */
    fun incrementBalance() {
        model.incrementBalance()
    }

    /**
     * Attempts ro resets the value of the [Model][ui.lectures.undoredo.forward.model.Model].
     */
    fun resetBalance() {
        model.resetBalance()
    }

    /**
     * Attempts to undo the last command from the [Model][ui.lectures.undoredo.forward.model.Model].
     */
    fun undo() {
        model.undo()
    }

    /**
     * Attempts to redo the last command on the [Model][ui.lectures.undoredo.forward.model.Model].
     */
    fun redo() {
        model.redo()
    }
}

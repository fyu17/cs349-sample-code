package ui.lectures.undoredo.backward.viewmodel

import javafx.beans.binding.Bindings
import javafx.beans.property.SimpleStringProperty
import ui.lectures.undoredo.backward.model.BalanceModel

class BalanceViewModel(private val model: BalanceModel) {

    /**
     * A string-representation of the current value of the [Model][ui.lectures.undoredo.backward.model.BalanceModel]
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
     * Attempts to increment the value of the [Model][ui.lectures.undoredo.backward.model.BalanceModel] by one.
     */
    fun incrementCounter() {
        model.incrementBalance()
    }

    /**
     * Attempts ro resets the value of the [Model][ui.lectures.undoredo.backward.model.BalanceModel].
     */
    fun resetCounter() {
        model.resetBalance()
    }

    /**
     * Attempts to undo the last command from the [Model][ui.lectures.undoredo.backward.model.BalanceModel].
     */
    fun undo() {
        model.undo()
    }

    /**
     * Attempts to redo the last command on the [Model][ui.lectures.undoredo.backward.model.BalanceModel].
     */
    fun redo() {
        model.redo()
    }
}

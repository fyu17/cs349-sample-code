package ui.lectures.undoredo.backward.model

import javafx.beans.property.ReadOnlyIntegerProperty
import javafx.beans.property.ReadOnlyIntegerWrapper
import ui.lectures.undoredo.backward.model.commands.IntIncrementCommand
import ui.lectures.undoredo.backward.model.commands.ResetCommand
import ui.lectures.undoredo.backward.model.commands.UndoableCommand

/**
 * Model represents the "Model" in "Model-View-ViewModel".
 */
class BalanceModel {

    private val initialBalance = 0

    // the undo- and redo-stacks for the executed commands
    private val undoCommands = mutableListOf<Any>()
    private val redoCommands = mutableListOf<Any>()

    // the current value of the Model
    private val _balance = ReadOnlyIntegerWrapper(initialBalance)

    /**
     * The current value of the [BalanceModel], exposed as a read-only Property
     */
    val balanceProperty: ReadOnlyIntegerProperty = _balance.readOnlyProperty

    /**
     * Increments the value of the [BalanceModel] by one.
     */
    fun incrementBalance() {
        IntIncrementCommand().apply {
            undoCommands.add(this)
            _balance.value = execute(_balance.value)
        }
        redoCommands.clear()
    }

    /**
     * Resets the value of the [BalanceModel].
     */
    fun resetBalance() {
        ResetCommand(initialBalance).apply {
            undoCommands.add(this)
            _balance.value = execute(_balance.value)
        }
        redoCommands.clear()
    }

    /**
     * Undoes the previously executed action (increment, reset, or redo)
     */
    fun undo() {
        undoCommands.removeLastOrNull()?.apply {
            redoCommands.add(this)
            _balance.value = (this as UndoableCommand<Int>).undo(_balance.value)
        }
    }

    /**
     * Redoes the previously executed action (increment, reset, or redo)
     */
    fun redo() {
        redoCommands.removeLastOrNull()?.apply {
            undoCommands.add(this)
            _balance.value = (this as UndoableCommand<Int>).execute(_balance.value)
        }
    }
}
package ui.lectures.undoredo.forward.model

import javafx.beans.property.ReadOnlyIntegerProperty
import javafx.beans.property.ReadOnlyIntegerWrapper
import ui.lectures.undoredo.forward.model.commands.IntIncrementCommand
import ui.lectures.undoredo.forward.model.commands.ResetCommand
import ui.lectures.undoredo.forward.model.commands.Command
import ui.lectures.undoredo.forward.model.commands.Memento

/**
 * Model represents the "Model" in "Model-View-ViewModel".
 */
class Model {

    private val initialBalance = 0

    // the current value of the Model
    private val _balance = ReadOnlyIntegerWrapper(initialBalance)

    /**
     * The current value of the [Model], exposed as a read-only Property
     */
    val balanceProperty: ReadOnlyIntegerProperty = _balance.readOnlyProperty

    // the undo- and redo-stacks for the executed commands
    private val undoCommands = mutableListOf<Any>(Memento(_balance.value))
    private val redoCommands = mutableListOf<Any>()

    /**
     * Increments the value of the [Model] by one.
     */
    fun incrementBalance() {
        IntIncrementCommand().apply {
            undoCommands.add(this)
            _balance.value = execute(_balance.value)
        }
        redoCommands.clear()
    }

    /**
     * Resets the value of the [Model].
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
        if (undoCommands.size > 1) {
            undoCommands.removeLast().apply {
                redoCommands.add(this)
                _balance.value = undoCommands.fold((undoCommands.first() as Memento<Int>).execute(0)) {
                        acc, cur -> (cur as Command<Int>).execute(acc)
                    }
            }
        }
    }

    /**
     * Redoes the previously executed action (increment, reset, or redo)
     */
    fun redo() {
        redoCommands.removeLastOrNull()?.apply {
            undoCommands.add(this)
            _balance.value = (this as Command<Int>).execute(_balance.value)
        }
    }
}
package ui.lectures.undoredo.backward.model.commands

/**
 * Encapsulates a reset command, i.e., a command that resets a value to its original state.
 */
class ResetCommand<T>(private val resetValue : T) : UndoableCommand<T> {

    private var preResetValue = resetValue

    /**
     * Returns the [resetValue].
     * @param value the current value
     * @return [resetValue]
     */
    override fun execute(value: T) : T {
        preResetValue = value
        return resetValue
    }

    /**
     * Returns the value before the reset.
     * @param value ignored
     * @return value before the reset
     */
    override fun undo(value: T) : T {
        return  preResetValue
    }
}
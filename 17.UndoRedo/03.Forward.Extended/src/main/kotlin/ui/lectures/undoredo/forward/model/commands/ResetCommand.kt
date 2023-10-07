package ui.lectures.undoredo.forward.model.commands

/**
 * Encapsulates a reset command, i.e., a command that resets a value to its original state.
 */
class ResetCommand<T>(private val resetValue : T) : Command<T> {

    /**
     * Returns the [resetValue].
     * @param value ignored
     * @return [resetValue]
     */
    override fun execute(value: T) : T {
        return resetValue
    }
}
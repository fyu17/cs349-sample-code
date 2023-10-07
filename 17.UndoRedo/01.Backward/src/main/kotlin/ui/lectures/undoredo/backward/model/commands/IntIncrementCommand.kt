package ui.lectures.undoredo.backward.model.commands

/**
 * Encapsulates an increment command, i.e., a command that increments a value by 1.
 */
class IntIncrementCommand : UndoableCommand<Int> {

    /**
     * Executes the command inc(value).
     * @param value the current value
     * @return inc(value)
     */
    override fun execute(value: Int) : Int {
        return value + 1
    }

    /**
     * Executes the command dec(value).
     * @param value the current value
     * @return dec(value)
     */
    override fun undo(value: Int) : Int {
        return  value - 1
    }
}
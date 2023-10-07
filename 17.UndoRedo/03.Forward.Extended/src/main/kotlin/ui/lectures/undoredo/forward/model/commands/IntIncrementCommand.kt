package ui.lectures.undoredo.forward.model.commands

/**
 * Encapsulates an increment command, i.e., a command that increments a value by 1.
 */
class IntIncrementCommand : Command<Int> {

    /**
     * Executes the command inc(value).
     * @param value the current value
     * @return inc(value)
     */
    override fun execute(value: Int) : Int {
        return value + 1
    }
}
package ui.lectures.undoredo.forward.model.commands

/**
 * Encapsulates a command.
 */
interface Command<T> {

    /**
     * Executes the command f(value).
     * @param value the current value
     * @return f(value)
     */
    fun execute(value: T) : T
}
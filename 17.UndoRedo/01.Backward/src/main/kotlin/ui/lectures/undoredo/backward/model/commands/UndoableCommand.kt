package ui.lectures.undoredo.backward.model.commands

/**
 * Encapsulates an undo-able command.
 */
interface UndoableCommand<T> : Command<T> {

    /**
     * Executes the command f^-1(value), i.e., undo f(value).
     * @param value the current value
     * @return f^-1(value)
     */
    fun undo(value: T) : T
}
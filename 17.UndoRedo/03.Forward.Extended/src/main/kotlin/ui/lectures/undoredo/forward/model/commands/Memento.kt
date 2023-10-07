package ui.lectures.undoredo.forward.model.commands

/**
 * Memento saves the current state of the Model.
 * @param savedState the state to be saved
 */
class Memento<T>(private val savedState: T) : Command<T> {

    /**
     * Returns the [savedState].
     * @param value ignored
     * @return [savedState]
     */
    override fun execute(value: T): T {
        return savedState
    }
}
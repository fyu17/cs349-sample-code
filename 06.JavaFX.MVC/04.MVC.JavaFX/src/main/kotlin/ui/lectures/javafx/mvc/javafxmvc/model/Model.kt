package ui.lectures.javafx.mvc.javafxmvc.model

import javafx.beans.InvalidationListener
import javafx.beans.Observable

/**
 * Model represents the "Model" in "Model-View-Controller".
 */
class Model : Observable {

    // a list of all subscribed views / views that listen to the model / views that observe the model
    private val views = mutableListOf<InvalidationListener?>()

    /**
     * Add listener to receive notifications about changes in the [Model].
     * @param listener the listener that is added to the [Model]
     */
    override fun addListener(listener: InvalidationListener?) {
        views.add(listener)
    }

    /**
     * Remove listener to stop receiving notifications about changes in the [Model].
     * @param listener the listener that is removed from the [Model]
     */
    override fun removeListener(listener: InvalidationListener?) {
        views.remove(listener)
    }

    // the current value of the Model
    private var myValue = 0.0

    /**
     * Returns the current value of the [Model].
     */
    fun getValue() : Double {
        return myValue
    }

    /**
     * Increments the value of the [Model] by one and invalidates all added listeners.
     */
    fun incrementValue() {
        myValue += 1.0
        views.forEach { it?.invalidated(this) }
    }

    /**
     * Resets the value of the [Model] and invalidates all added listeners.
     */
    fun reset() {
        myValue = 0.0
        views.forEach { it?.invalidated(this) }
    }
}
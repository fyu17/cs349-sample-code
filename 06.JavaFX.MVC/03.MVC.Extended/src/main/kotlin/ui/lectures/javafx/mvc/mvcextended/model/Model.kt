package ui.lectures.javafx.mvc.mvcextended.model

import ui.lectures.javafx.mvc.mvcextended.view.View

/**
 * Model represents the "Model" in "Model-View-Controller".
 */
class Model {

    // a list of all subscribed views / views that listen to the model / views that observe the model
    private val views = mutableListOf<View>()

    /**
     * Subscribe to receive notifications about changes in the [Model].
     * @param view the [View][ui.lectures.javafx.mvc.mvcextended.view.View] that subscribes to the [Model]
     */
    fun addView(view: View) {
        views.add(view)
    }

    /**
     * The minimum value of the Model
     */
    val minValue = 0.0

    /**
     * The maximum value of the Model
     */
    val maxValue = 10.0

    // the current value of the Model
    private var myValue = minValue

    /**
     * Returns the current value of the [Model].
     */
    fun getValue() : Double {
        return myValue
    }

    /**
     * Sets the value of the [Model] and notifies all subscribed [Views][ui.lectures.javafx.mvc.mvcextended.view.View].
     */
    fun setValue(newValue: Double) {
        myValue = newValue.coerceIn(minValue, maxValue)
        views.forEach { it.update() }
    }

    /**
     * Increments the value of the [Model] by one and notifies all subscribed [Views][ui.lectures.javafx.mvc.mvcextended.view.View].
     */
    fun incrementValue() {
        setValue(myValue + 1.0)
    }

    /**
     * Resets the value of the [Model] and notifies all subscribed [Views][ui.lectures.javafx.mvc.mvcextended.view.View].
     */
    fun reset() {
        setValue(minValue)
    }
}
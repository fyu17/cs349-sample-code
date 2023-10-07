package ui.lectures.javafx.mvc.propertiesmvc.model

import javafx.beans.property.ReadOnlyDoubleProperty
import javafx.beans.property.ReadOnlyDoubleWrapper

/**
 * Model represents the "Model" in "Model-View-Controller".
 */
class Model {

    // the current value of the Model
    private val myValue = ReadOnlyDoubleWrapper(0.0)

    /**
     * the current value of the [Model], exposed as a read-only Property
     */
    val MyValue: ReadOnlyDoubleProperty = myValue.readOnlyProperty

    /**
     * Increments the value of the [Model] by one and notifies all listeners.
     */
    fun incrementValue() {
        myValue.value += 1.0
    }

    /**
     * Resets the value of the [Model] and notifies all listeners.
     */
    fun reset() {
        myValue.value = 0.0
    }
}
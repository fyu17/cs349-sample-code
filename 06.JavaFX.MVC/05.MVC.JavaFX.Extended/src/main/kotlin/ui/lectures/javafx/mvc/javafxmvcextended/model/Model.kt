package ui.lectures.javafx.mvc.javafxmvcextended.model

import javafx.beans.InvalidationListener
import javafx.beans.Observable
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.roundToInt

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
     * Sets the value of the [Model] and invalidates all added listeners.
     */
    fun setValue(newValue: Double) {
        myValue = newValue.coerceIn(minValue, maxValue)
        views.forEach { it?.invalidated(this) }
    }

    /**
     * Increments the value of the [Model] by one and invalidates all added listeners.
     */
    fun incrementValue() {
        setValue(myValue + 1.0)
    }

    /**
     * Resets the value of the [Model] and invalidates all added listeners.
     */
    fun resetValue() {
        setValue(minValue)
    }

    // the current list of the Model
    private val myList = MutableList(1) { 0.0 } // initializes the list with [0.0]

    /**
     * Returns the current list of the [Model].
     */
    fun getList() : List<Double> {
        return myList.toList() // returns a copy of myList
    }

    /**
     * Adds the value of the [Model], rounded to two decimals, to the list of the [Model] and invalidates all added listeners.
     */
    fun addToList() {
        myList.add(BigDecimal(myValue).setScale(2, RoundingMode.HALF_EVEN).toDouble())
        views.forEach { it?.invalidated(this) }
    }

    /**
     * Resets the list of the [Model] and invalidates all added listeners.
     */
    fun resetList() {
        myList.clear()
        views.forEach { it?.invalidated(this) }
    }
}
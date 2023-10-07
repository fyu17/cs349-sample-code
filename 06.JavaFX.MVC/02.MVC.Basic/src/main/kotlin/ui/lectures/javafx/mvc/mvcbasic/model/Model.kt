package ui.lectures.javafx.mvc.mvcbasic.model

import ui.lectures.javafx.mvc.mvcbasic.view.View

/**
 * Model represents the "Model" in "Model-View-Controller".
 */
class Model {

    // a list of all subscribed views / views that listen to the model / views that observe the model
    private val views = mutableListOf<View>()

    /**
     * Subscribe to receive notifications about changes in the [Model].
     * @param view the [View][ui.lectures.javafx.mvc.mvcbasic.view.View] that subscribes to the [Model]
     */
    fun addView(view: View) {
        views.add(view)
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
     * Increments the value of the [Model] by one and notifies all subscribed [Views][ui.lectures.javafx.mvc.mvcbasic.view.View].
     */
    fun incrementValue() {
        ++myValue
        views.forEach { it.update() }
    }
}
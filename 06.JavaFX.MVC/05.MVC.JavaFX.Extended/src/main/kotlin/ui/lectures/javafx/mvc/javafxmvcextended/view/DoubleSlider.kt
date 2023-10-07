package ui.lectures.javafx.mvc.javafxmvcextended.view

import javafx.beans.InvalidationListener
import javafx.beans.Observable
import javafx.beans.value.ChangeListener
import javafx.beans.value.ObservableValue
import javafx.scene.control.Slider
import ui.lectures.javafx.mvc.javafxmvcextended.model.Model

/**
 * DoubleSlider displays the value of the [Model][ui.lectures.javafx.mvc.javafxmvcextended.model.Model] and allows for mutating that value as well.
 */
class DoubleSlider(private val model: Model) : Slider(), InvalidationListener {
    init {
        min = model.minValue // set min value of the slider based on minValue in the Model
        max = model.maxValue // set max value of the slider based on maxValue in the Model
        model.addListener(this) // listen to the Model
        valueProperty().addListener { _ ->
            model.setValue(value) // set value of Model according to the value of the slider; this does NOT cause an infinite loop with the invalidated function (below)!
        }
        invalidated(null) // set initial value
    }

    override fun invalidated(observable: Observable?) {
        value = model.getValue() // set value of slider if notified by the Model; this does NOT cause an infinite loop with the valueProperty (above)!
    }


}
package ui.lectures.javafx.mvc.mvcextended.view

import javafx.scene.control.Slider
import ui.lectures.javafx.mvc.mvcextended.model.Model

/**
 * DoubleSlider displays the value of the [Model][ui.lectures.javafx.mvc.javafxmvc.model.Model] and allows for mutating that value as well.
 */
class DoubleSlider(private val model: Model) : Slider(), View {
    init {
        min = model.minValue // set min value of the slider based on minValue in the Model
        max = model.maxValue // set max value of the slider based on maxValue in the Model
        model.addView(this) //subscribe to the Model
        valueProperty().addListener { _ ->
            model.setValue(value) // set value of Model according to the value of the slider; this does NOT cause an infinite loop with the update function (below)!
        }
        update() // set initial value
    }
    override fun update() {
        value = model.getValue() // set value of slider if notified by the Model; this does NOT cause an infinite loop with the valueProperty (above)!
    }
}
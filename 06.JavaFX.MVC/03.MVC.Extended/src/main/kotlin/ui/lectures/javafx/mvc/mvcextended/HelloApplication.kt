package ui.lectures.javafx.mvc.mvcextended

import javafx.application.Application
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Separator
import javafx.scene.layout.VBox
import javafx.stage.Stage
import ui.lectures.javafx.mvc.mvcextended.controller.IncrementButton
import ui.lectures.javafx.mvc.mvcextended.controller.ResetButton
import ui.lectures.javafx.mvc.mvcextended.model.Model
import ui.lectures.javafx.mvc.mvcextended.view.DoubleLabel
import ui.lectures.javafx.mvc.mvcextended.view.DoubleSlider

class HelloExtendedMVC : Application() {
    override fun start(stage: Stage) {

        val myModel = Model()

        val valueLabel = DoubleLabel(myModel)
        val valueSlider = DoubleSlider(myModel)

        val incrementButton = IncrementButton(myModel)
        val resetButton = ResetButton(myModel)

        stage.apply {
            title = "Hello CS349! - JavaFX.MVC.BasicMVC"
            scene = Scene(VBox(
                valueLabel,
                valueSlider,
                Separator(Orientation.HORIZONTAL),
                incrementButton,
                resetButton
            ).apply {
                alignment = Pos.CENTER
                spacing = 10.0
            }, 320.0, 240.0)
        }.show()
    }
}
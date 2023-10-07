package ui.lectures.javafx.mvc.javafxmvc

import javafx.application.Application
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Separator
import javafx.scene.layout.VBox
import javafx.stage.Stage
import ui.lectures.javafx.mvc.javafxmvc.controller.IncrementButton
import ui.lectures.javafx.mvc.javafxmvc.controller.ResetButton
import ui.lectures.javafx.mvc.javafxmvc.model.Model
import ui.lectures.javafx.mvc.javafxmvc.view.DoubleLabel

class HelloJavaFXMVC : Application() {
    override fun start(stage: Stage) {

        val myModel = Model() // model
        val valueLabel = DoubleLabel(myModel) // view
        val incrementButton = IncrementButton(myModel) // controller
        val resetButton = ResetButton(myModel) // controller

        stage.apply {
            title = "Hello CS349! - JavaFX.MVC.BasicMVC"
            scene = Scene(VBox(
                valueLabel,
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
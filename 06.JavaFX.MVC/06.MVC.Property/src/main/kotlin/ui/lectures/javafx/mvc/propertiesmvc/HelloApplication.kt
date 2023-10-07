package ui.lectures.javafx.mvc.propertiesmvc

import javafx.application.Application
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Separator
import javafx.scene.layout.VBox
import javafx.stage.Stage
import ui.lectures.javafx.mvc.propertiesmvc.controller.IncrementButton
import ui.lectures.javafx.mvc.propertiesmvc.controller.ResetButton
import ui.lectures.javafx.mvc.propertiesmvc.model.Model
import ui.lectures.javafx.mvc.propertiesmvc.view.DoubleLabel
import ui.lectures.javafx.mvc.propertiesmvc.view.ExtendedDoubleLabel

class HelloPropertiesMVC : Application() {
    override fun start(stage: Stage) {

        val myModel = Model() // model

        stage.apply {
            title = "Hello CS349! - JavaFX.MVC.BasicMVC"
            scene = Scene(VBox(
                DoubleLabel(myModel), // view
                ExtendedDoubleLabel(myModel), // view
                Separator(Orientation.HORIZONTAL),
                IncrementButton(myModel), // controller
                ResetButton(myModel) // controller
            ).apply {
                alignment = Pos.CENTER
                spacing = 10.0
            }, 320.0, 240.0)
        }.show()
    }
}
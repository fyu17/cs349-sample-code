package ui.lectures.javafx.mvc.mvcbasic

import javafx.application.Application
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Separator
import javafx.scene.layout.VBox
import javafx.stage.Stage
import ui.lectures.javafx.mvc.mvcbasic.controller.IncrementButton
import ui.lectures.javafx.mvc.mvcbasic.model.Model
import ui.lectures.javafx.mvc.mvcbasic.view.DoubleLabel

class HelloBasicMVC : Application() {
    override fun start(stage: Stage) {

        val myModel = Model() // model
        val doubleLabel = DoubleLabel(myModel) // view
        val incrementButton = IncrementButton(myModel) // controller

        stage.apply {
            title = "Hello CS349! - JavaFX.MVC.BasicMVC"
            scene = Scene(VBox(
                doubleLabel,
                Separator(Orientation.HORIZONTAL),
                incrementButton
            ).apply {
                alignment = Pos.CENTER
                spacing = 10.0
            }, 320.0, 240.0)
        }.show()
    }
}
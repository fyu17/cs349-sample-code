package ui.lectures.javafx.mvc.javafxmvcextended

import javafx.application.Application
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Separator
import javafx.scene.layout.VBox
import javafx.stage.Stage
import ui.lectures.javafx.mvc.javafxmvcextended.controller.AddButton
import ui.lectures.javafx.mvc.javafxmvcextended.controller.IncrementButton
import ui.lectures.javafx.mvc.javafxmvcextended.controller.ResetListButton
import ui.lectures.javafx.mvc.javafxmvcextended.controller.ResetValueButton
import ui.lectures.javafx.mvc.javafxmvcextended.model.Model
import ui.lectures.javafx.mvc.javafxmvcextended.view.DoubleLabel
import ui.lectures.javafx.mvc.javafxmvcextended.view.DoubleSlider
import ui.lectures.javafx.mvc.javafxmvcextended.view.ListView

class HelloJavaFXMVCExtended : Application() {
    override fun start(stage: Stage) {

        val myModel = Model()

        val valueLabel = DoubleLabel(myModel)
        val valueSlider = DoubleSlider(myModel)

        val incrementButton = IncrementButton(myModel)
        val resetButton = ResetValueButton(myModel)

        stage.apply {
            title = "Hello CS349! - JavaFX.MVC.BasicMVC"
            scene = Scene(VBox(
                valueLabel,
                valueSlider,
                ListView(myModel),
                Separator(Orientation.HORIZONTAL),
                incrementButton,
                resetButton,
                AddButton(myModel),
                ResetListButton(myModel),
            ).apply {
                alignment = Pos.CENTER
                spacing = 10.0
            }, 320.0, 320.0)
        }.show()
    }
}
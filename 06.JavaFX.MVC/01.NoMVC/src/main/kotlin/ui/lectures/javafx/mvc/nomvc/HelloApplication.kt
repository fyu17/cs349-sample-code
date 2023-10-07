package ui.lectures.javafx.mvc.nomvc

import javafx.application.Application
import javafx.event.EventHandler
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.Separator
import javafx.scene.layout.VBox
import javafx.stage.Stage

class HelloNoMVC : Application() {
    override fun start(stage: Stage) {

        val valueLabel = Label("0")

        val incrementButton = Button("Increment").apply {
            onAction = EventHandler {
                valueLabel.text = (valueLabel.text.toInt() + 1).toString()
            }
        }

        stage.apply {
            title = "Hello CS349! - JavaFX.MVC.NoMVC"
            scene = Scene(VBox(
                valueLabel,
                Separator(Orientation.HORIZONTAL),
                incrementButton
            ).apply {
                alignment = Pos.CENTER
                spacing = 10.0
            }, 320.0, 240.0)
        }.show()
    }
}
package clock

import clock.model.Model
import clock.view.ClockView
import clock.view.TimeView
import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyCodeCombination
import javafx.scene.input.KeyCombination
import javafx.scene.input.KeyEvent
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import javafx.stage.Stage
import kotlin.system.exitProcess

fun main() {
    Application.launch(Main::class.java)
}

class Main : Application() {

    override fun start(stage: Stage) {
        // setup model to process time changes
        val model = Model()

        // analog time
        val clockView = ClockView(model)
        val clockPane = StackPane(clockView)
        clockPane.setPrefSize(250.0, 250.0)
        model.views.add(clockView)

        // digital time
        val timeView = TimeView(model)
        val timePane = StackPane(timeView)
        timePane.setPrefSize(250.00, 75.0)
        model.views.add(timeView)

        // show scene & stage
        val scene = Scene(VBox(clockPane, timePane))
        scene.onKeyPressed = EventHandler { event: KeyEvent? ->
            if (KeyCodeCombination(KeyCode.Q, KeyCombination.ALT_DOWN).match(event)) {
                model.stop()
                exitProcess(0)
            }
        }
        stage.scene = scene
        stage.onCloseRequest = EventHandler {
            model.stop()
            exitProcess(0)
        }
        stage.title = "Clock"
        stage.isResizable = false
        stage.isAlwaysOnTop = true
        stage.width = 250.0
        stage.height = 325.0
        stage.show()

        // start model ticking
        model.start()
    }
}
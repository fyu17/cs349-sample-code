import javafx.application.Application
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.Slider
import javafx.scene.layout.GridPane
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.stage.Stage
import kotlin.system.exitProcess

class WidgetDemo : Application() {
    override fun start(stage: Stage) {
        val label = Label("This is a label!")
        label.translateX = 50.0

        val button = Button("Click me!")
        button.translateX = 50.0
        button.setOnKeyPressed { println("key pressed") }
        button.setOnMouseClicked { println("button clicked") }

        val slider = Slider(0.0, 100.0, 50.0)
        slider.translateX = 50.0
        slider.setOnMouseDragged { mouseEvent -> println("slider " + (mouseEvent.source as Slider).value) }

        val grid = GridPane()
        grid.padding = Insets(20.0)
        grid.hgap = 6.0
        grid.vgap = 6.0

        grid.addRow(0, Label("Label:"), label)
        grid.addRow(1, Label("Button:"), button)
        grid.addRow(2, Label("Slider:"), slider)

        val root = StackPane(grid)
        root.alignment = Pos.CENTER
        stage.scene = Scene(StackPane(root), 275.0, 125.0, Color.WHITE)
        stage.title = "CS349 :-)"
        stage.isResizable = false
        stage.setOnCloseRequest { exitProcess(0) }
        stage.show()
    }
}
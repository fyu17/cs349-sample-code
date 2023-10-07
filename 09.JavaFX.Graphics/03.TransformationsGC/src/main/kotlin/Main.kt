import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color
import javafx.stage.Stage

// Draw using a canvas class instead.
class Main : Application() {
    override fun start(stage: Stage) {

        // Create a scene graph with a root node
        // This will hold the objects that we want to display on the stage
        val root = Group()

        // Create a canvas as a drawing surface
        val canvas = Canvas(300.0, 300.0)
        val gc = canvas.graphicsContext2D

        // Use the graphics context to draw
        gc.lineWidth = 5.0
        gc.stroke = Color.BLACK

        // first shape, not filled
        gc.fill = Color.YELLOW
        gc.strokeRect(75.0, 75.0, 100.0, 100.0)

        // second shape, filled and offset
        gc.fill = Color.AQUA
        gc.translate(25.0, 25.0)
        gc.fillRect(75.0, 75.0, 100.0, 100.0)

        // third shape, filled and offset even further
        gc.fill = Color.YELLOWGREEN
        gc.translate(25.0, 25.0)

        gc.fillRect(75.0, 75.0, 100.0, 100.0)

        // how can I rotate it in-place?
        gc.fill = Color.CADETBLUE
        gc.translate(25.0, 25.0)

        gc.translate(125.0, 125.0)
        gc.rotate(45.0)
        gc.translate(-125.0, -125.0)
        gc.fillRect(75.0, 75.0, 100.0, 100.0)

        // Add the canvas to the scene
        root.children.add(canvas)
        val scene = Scene(root, 300.0, 300.0, Color.WHITE)

        // Add the scene to the stage and show it
        stage.title = "Drawing Canvas"
        stage.scene = scene
        stage.show()
    }
}
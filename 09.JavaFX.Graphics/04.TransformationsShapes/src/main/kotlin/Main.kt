import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.input.MouseEvent
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.stage.Stage

// Draw using shape classes
class Main : Application() {
    override fun start(stage: Stage) {

        // Create a scene graph with a root node
        // This will hold the objects that we want to display on the stage
        val root = Group()

        // shapes are just nodes
        val rect1 = Rectangle(75.0, 75.0, 100.0, 100.0)
        rect1.stroke = Color.BLACK
        rect1.fill = Color.WHITE

        // second shape, filled and offset
        val rect2 = Rectangle(75.0, 75.0, 100.0, 100.0)
        rect2.fill = Color.AQUA
        rect2.translateX = 25.0
        rect2.translateY = 25.0

        // third shape, filled and offset even further
        val rect3 = Rectangle(75.0, 75.0, 100.0, 100.0)
        rect3.fill = Color.YELLOWGREEN
        rect3.translateX = 50.0 // note these are absolute, NOT cumulative
        rect3.translateY = 50.0

        // how can I rotate it in-place?
        // rect3.rotate = 45.0

        // Add nodes to the scene
        root.children.addAll(rect1, rect2, rect3)
        val scene = Scene(root, 300.0, 300.0, Color.WHITE)

        // Add the scene to the stage and show it
        stage.title = "Drawing Shapes"
        stage.scene = scene
        stage.show()
    }
}
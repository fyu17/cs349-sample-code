import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.stage.Stage
import java.util.*

class Main : Application() {
    override fun start(stage: Stage) {
        val root = Group()
        val scene = Scene(root, 600.0, 400.0)
        var rectangle: Rectangle? = null

        // mouse down
        scene.setOnMousePressed { event ->
            rectangle = Rectangle()
            rectangle?.x = event.x
            rectangle?.y = event.y
            rectangle?.width = 1.0
            rectangle?.height = 1.0
            rectangle?.fill = Color.color(Random().nextDouble(1.0), Random().nextDouble(1.0), Random().nextDouble(1.0))
            root.children.add(rectangle)
        }

        // drag movement
        scene.setOnMouseDragged { event ->
            rectangle?.width = event.x - (rectangle?.x ?: 0.0)
            rectangle?.height = event.y - (rectangle?.y ?: 0.0)
        }

        // mouse up
        scene.setOnMouseReleased { event ->
            with(rectangle) {
                this?.setOnMousePressed { event ->
                    this.toFront()
                }
                this?.setOnMouseDragged { event ->
                    this.x = (event.x - 10.0)
                    this.y = (event.y - 10.0)
                    event.consume()
                }
            }
        }

        stage.scene = scene
        stage.isResizable = false
        stage.show()
    }
}
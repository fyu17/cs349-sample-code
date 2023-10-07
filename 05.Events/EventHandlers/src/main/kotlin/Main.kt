import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.input.MouseEvent
import javafx.scene.layout.StackPane
import javafx.scene.paint.*
import javafx.scene.shape.Rectangle
import javafx.stage.Stage

// Use Event Handlers to process mouse-clicks on the bubble phase.
class EventHandlers : Application() {

    fun toggleColour(current: Paint?, colour1: Color, colour2: Color): Color {
        return (if (current == colour1) colour2 else colour1)
    }

    override fun start(stage: Stage) {
        val group = StackPane()
        val scene = Scene(group, 400.0, 300.0)

        // setup background
        scene.fill = Color.GRAY
        val sceneHandler =
            EventHandler<MouseEvent> { event: MouseEvent ->
                println("Scene clicked (${event.x}, ${event.y})")
                scene.fill = toggleColour(scene.fill, Color.GRAY, Color.DARKGRAY)
            }

        // register as an EventHandler, which is fired during the BUBBLE (up) phase
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, sceneHandler)

//        // this is registered for bubble phase too!
//        scene.setOnMouseClicked { event ->
//            println("Scene clicked (${event.x}, ${event.y})")
//            scene.fill = toggleColour(scene.fill, Color.GRAY, Color.DARKGRAY)
//            // event.consume()
//        }

        // add foreground shape
        val rectangle = Rectangle(125.0, 150.0, Color.YELLOW)
        val rectangleHandler =
            EventHandler<MouseEvent> { event : MouseEvent ->
                println("Node clicked (${event.x}, ${event.y})")
                rectangle.fill = toggleColour(rectangle.fill, Color.YELLOW, Color.DARKGOLDENROD)
                // event.consume()
            }

        // register as an EventHandler, which is fired during the BUBBLE (up) phase
        rectangle.addEventHandler(MouseEvent.MOUSE_CLICKED, rectangleHandler)

        // add to the scene and display
        group.children.add(rectangle)

        stage.title = "EventHandlers2: Event Handlers"
        stage.scene = scene
        stage.show()
    }
}
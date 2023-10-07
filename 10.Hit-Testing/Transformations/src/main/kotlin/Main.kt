import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color
import javafx.stage.Stage

class Main : Application() {
    val WINDOW_WIDTH = 800.0
    val WINDOW_HEIGHT = 600.0

    override fun start(stage: Stage) {
        // Print help
        println("INSTRUCTIONS")
        println("Left, Right, Up, Down: Translate the shape")
        println("R, Shift-R: Rotate clockwise/counterclockwise")
        println("S, Shift-S: Scale the shape larger/smaller")
        println("Z: Remove all transformations")

        // Setup the canvas and shape to draw
        val canvas = Canvas(WINDOW_WIDTH, WINDOW_HEIGHT)
        var house = House()

        // Draw the initial shape
        canvas.clear()
        house.stepX(10)
        house.stepY(10)
        house.draw(canvas)

        // Create the scene graph
        val root = Group()
        root.children.add(canvas)

        // Setup mouse handlers
        var startingMousePosition = Pair(0.0, 0.0)

        canvas.setOnMousePressed { event ->
            startingMousePosition = Pair(event.x, event.y)
        }

        canvas.setOnMouseDragged { event ->
            house.translateX(event.x - startingMousePosition.first)
            house.translateY(event.y - startingMousePosition.second)
            startingMousePosition = Pair(event.x, event.y)
            canvas.clear()
            house.draw(canvas)
        }

        // Setup the scene and add to the stage
        val mainScene = Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT, Color.GHOSTWHITE)
        mainScene.setOnKeyPressed { event ->
            when(event.code) {
                javafx.scene.input.KeyCode.UP -> house.stepY(-1)
                javafx.scene.input.KeyCode.DOWN -> house.stepY(1)
                javafx.scene.input.KeyCode.LEFT -> house.stepX(-1)
                javafx.scene.input.KeyCode.RIGHT -> house.stepX(1)
                javafx.scene.input.KeyCode.R -> if(event.isShiftDown) house.rotate(-1) else house.rotate(1)
                javafx.scene.input.KeyCode.S -> if(event.isShiftDown) house.scaleDown(1) else house.scaleUp(1)
                javafx.scene.input.KeyCode.Z -> house.matrix.setToIdentity()
                else -> house.matrix.appendTranslation(0.0, 0.0)
            }
            canvas.clear()
            house.draw(canvas)
        }

        with(stage) {
            title = "Hit Testing/Transformations"
            scene = mainScene
            isResizable = false
            show()
        }
    }

    fun Canvas.clear() {
        with(this.graphicsContext2D) {
            fill = Color.GHOSTWHITE
            clearRect(-500.0, -500.0, WINDOW_WIDTH + 500.0, WINDOW_HEIGHT + 500.0)
        }
    }
}
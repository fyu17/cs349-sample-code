import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.stage.Stage

class Main : Application() {
    override fun start(stage: Stage) {
        val canvas = Canvas(500.0, 500.0)

        with (canvas) {
            scaleX = 3.0
            scaleY = 3.0

            // clear bg and draw a grid
            with (graphicsContext2D) {
                clearRect(0.0, 0.0, canvas.width, canvas.height)
                translate(200.0, 200.0)
                lineWidth = 0.5
                stroke = Color.LIGHTGRAY
                grid(0.0, 0.0, gridWidth = 100.0, cellWidth = 10.0)
            }

            // draw a square
            with(graphicsContext2D) {
                stage.title = "Cumulative Transformations"
                translate(5,5)
//                rotate(45)
                scale(2,2)
                square()
            }
        }

        val scene = Scene(StackPane(canvas), 400.0, 400.0)
        stage.scene = scene
        stage.isResizable = false
        stage.show()
    }
}
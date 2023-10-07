import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.stage.Stage

class Main : Application() {
    override fun start(stage: Stage) {
        val canvas = Canvas()

        with (canvas) {
            width = 300.0
            height = 300.0
            
            scaleX = 3.0
            scaleY = 3.0

            // setup the grid
            with (graphicsContext2D) {
                translate(25.0, 25.0)

                lineWidth = 0.5
                stroke = Color.LIGHTGRAY
                drawGrid(25, 25)
            }

            // draw handles
            with(graphicsContext2D) {
                translate(10.0, 10.0)
                drawHandle("A", Color.hsb(0.0, 1.0, 0.85))

                translate(50.0, 0.0)
                drawHandle("B", Color.hsb(60.0, 1.0, 0.85))

                translate(50.0, 0.0)
                rotate(30.0)
                drawHandle("C", Color.hsb(120.0, 1.0, 0.85))

                translate(50.0, 0.0)
                rotate(30.0)
                drawHandle("D", Color.hsb(180.0, 1.0, 0.85))

                translate(50.0, 0.0)
                rotate(-45.0)
                drawHandle("E", Color.hsb(270.0, 1.0, 0.85))

                translate(50.0, 0.0)
                rotate(135.0)
                drawHandle("F", Color.hsb(360.0, 1.0, 0.85))
            }
        }

        val scene = Scene(StackPane(canvas), (canvas.width * canvas.scaleX) + 20.0, (canvas.height * canvas.scaleY) + 20.0)
        stage.scene = scene
        stage.isResizable = false
        stage.show()
    }
}
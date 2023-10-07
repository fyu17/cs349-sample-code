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

            // origin
//            val houseX = doubleArrayOf(0.0, 0.0, -10.0, -20.0, -20.0)
//            val houseY = doubleArrayOf(0.0, -20.0, -30.0, -20.0, 0.0)

            // inset
             val houseX = doubleArrayOf(20.0, 20.0, 10.0, 00.0, 0.0)
             val houseY = doubleArrayOf(30.0, 10.0, 00.0, 10.0, 30.0)

            with (graphicsContext2D) {
                // clearRect(0.0, 0.0, canvas.width, canvas.height)

                // setup the grid
                lineWidth = 0.5
                stroke = Color.DARKGRAY
                translate(30.0, 30.0) // inset the grid
                drawGrid(25, 25)

                // draw the house
                stroke = Color.DARKBLUE

                // slide 19
                rotate(-30.0)
                scale(2.0, 1.0)
                translate(60.0,70.0)
                strokePolygon(houseX, houseY, 5)
            }
        }

        val scene = Scene(StackPane(canvas), (canvas.width * canvas.scaleX) + 60.0, (canvas.height * canvas.scaleY) + 60.0)
        stage.scene = scene
        stage.isResizable = false
        stage.show()
    }
}
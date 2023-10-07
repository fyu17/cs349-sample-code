import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color

// animatable scene using Canvas and GC drawing
class CanvasScene: Canvas(WIDTH, HEIGHT) {

    // parameter to animate
    var x: Double = 25.0

    fun draw() {
        val gc = graphicsContext2D
        gc.stroke = Color.RED
        gc.strokeOval(x - 25.0, HEIGHT/2 - 25.0, 50.0, 50.0)
    }
}

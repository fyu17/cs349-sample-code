import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color

var width: Double = 0.0

// grid GraphicsContext extension
fun GraphicsContext.grid(x: Double, y: Double, gridWidth: Double, cellWidth: Double) {
    val gc = this
    width = cellWidth
    var i = 0.0
    while (i <= gridWidth) {
        gc.strokeLine(x + i, y, x + i, y + gridWidth)
        gc.strokeLine(x, y + i, x + gridWidth, y + i )
        i += cellWidth
    }
}

// square drawing extension
fun GraphicsContext.square(c:Color = Color.BLUE) {
    val gc = this
    gc.fill = c
    gc.stroke = c
    gc.fillRect(0.0, 0.0, width, width)
}

fun GraphicsContext.translate(tx: Int, ty: Int) = this.translate(tx * width, ty * width)
fun GraphicsContext.scale(sx: Int, sy: Int) = this.scale(sx.toDouble(), sy.toDouble())
fun GraphicsContext.rotate(theta: Int) = this.rotate(theta.toDouble())
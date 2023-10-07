import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color

// GraphicsContext extension functions
// assumes 10px grid in calculations

fun GraphicsContext.drawGrid(rows: Int, cols: Int, cellWidth: Double = 10.0) {
    for (row in 0 until rows) {
        this.strokeLine(0 * cellWidth, row * cellWidth, (cols -1) * cellWidth, row * cellWidth)
    }
    for (col in 0 until cols) {
        this.strokeLine(col * cellWidth, 0 * cellWidth, col * cellWidth, (rows -1) * cellWidth)
    }
}

fun GraphicsContext.drawHandle(txt: String, col: Color = Color.BLUE) {
    save()
    stroke = col
    fill = col
    strokeLine(0.0, 0.0, 50.0, 0.0)
    fillOval(-5.0, -5.0, 10.0, 10.0)
    fillText(txt, 0.0, 0.0)

    fill = Color.WHITE
    fillOval(45.0, -5.0, 10.0, 10.0)
    strokeOval(45.0, -5.0, 10.0, 10.0)
    restore()
}

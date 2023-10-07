package ui.lectures.drawables.primitives

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color

class FillRect(x: Double, y: Double,
               var rectWidth: Double, var rectHeight: Double,
               var fillColor: Color,
               name: String): Drawable(x, y, name) {

    override fun draw(gc: GraphicsContext) {
        gc.apply {
            save()
            fill = fillColor
            fillRect(x, y, rectWidth, rectHeight)
            restore()
        }
    }

    override fun isHit(x: Double, y: Double): Boolean {
        return x.between(this.x, this.x + rectWidth) and y.between(this.y, this.y + rectHeight)
    }
}

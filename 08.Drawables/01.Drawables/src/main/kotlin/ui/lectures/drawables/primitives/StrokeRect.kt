package ui.lectures.drawables.primitives

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color

class StrokeRect(x: Double, y: Double,
                 val rectWidth: Double, val rectHeight: Double,
                 val strokeWidth: Double, val strokeColor: Color,
                 val hitDelta: Double,
                 name: String): Drawable(x, y, name) {

    override fun draw(gc: GraphicsContext) {
        gc.apply {
            save()
            lineWidth = strokeWidth
            stroke = strokeColor
            strokeRect(x, y, rectWidth, rectHeight)
            restore()
        }
    }

    override fun isHit(x: Double, y: Double): Boolean {
        return (x.between(this.x - hitDelta, this.x + rectWidth + hitDelta) and
                x.between(this.x + hitDelta, this.x + rectWidth - hitDelta).not() and
                y.between(this.y - hitDelta, this.y + rectHeight + hitDelta)) or
                (y.between(this.y - hitDelta, this.y + rectHeight + hitDelta) and
                y.between(this.y + hitDelta, this.y + rectHeight - hitDelta).not() and
                x.between(this.x - hitDelta, this.x + rectWidth + hitDelta))
    }
}

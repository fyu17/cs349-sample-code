package ui.lectures.drawables.primitives

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import kotlin.math.sqrt

class StrokeCirc(x: Double, y: Double,
                 var circDiameter: Double,
                 val strokeWidth: Double, val strokeColor: Color,
                 val hitDelta: Double,
                 name: String): Drawable(x, y, name) {

    override fun draw(gc: GraphicsContext) {
        gc.apply {
            save()
            lineWidth = strokeWidth
            stroke = strokeColor
            strokeOval(x, y, circDiameter, circDiameter)
            restore()
        }
    }

    override fun isHit(x: Double, y: Double): Boolean {
        return sqrt((x - this.x - circDiameter / 2.0).sqr() + (y - this.y - circDiameter / 2.0).sqr()).between(circDiameter / 2.0 - hitDelta, circDiameter / 2.0 + hitDelta)
    }
}

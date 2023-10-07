package ui.lectures.drawables.primitives

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import kotlin.math.sqrt

class FillCirc(x: Double, y: Double,
               var circDiameter: Double,
               var fillColor: Color,
               name: String): Drawable(x, y, name) {

    override fun draw(gc: GraphicsContext) {
        gc.apply {
            save()
            fill = fillColor
            fillOval(x, y, circDiameter, circDiameter)
            restore()
        }
    }

    override fun isHit(x: Double, y: Double): Boolean {
        return sqrt((x - this.x - circDiameter / 2.0).sqr() + (y - this.y - circDiameter / 2.0).sqr()) <= circDiameter / 2.0
    }
}

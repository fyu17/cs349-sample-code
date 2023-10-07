package ui.lectures.drawables.primitives

import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import kotlin.math.sqrt

class StrokeLine(x: Double, y: Double,
                 val xEnd: Double, val yEnd: Double,
                 val strokeWidth: Double, val strokeColor: Color,
                 val hitDelta: Double,
                 name: String): Drawable(x, y, name) {

    override fun draw(gc: GraphicsContext) {
        gc.apply {
            save()
            lineWidth = strokeWidth
            stroke = strokeColor
            strokeLine(x, y, xEnd, yEnd)
            restore()
        }
    }

    override fun isHit(x: Double, y: Double): Boolean {
        val ux = x - this.x
        val uy = y - this.y
        val vx = xEnd - this.x
        val vy = yEnd - this.y
        val t = (vx * ux + vy * uy) / ((vx * vx) + (vy * vy)) // u.v / v.v, assumes that length of v > 0.0
        // val t = if (abs(vx) + abs(vy) > 0.0) ... else 0.0
        val dst = if (t < 0.0) sqrt((x - this.x).sqr() + (y - this.y).sqr()) // past (x,y)
        else if (t > 1.0) sqrt((x - xEnd).sqr() + (y - yEnd).sqr()) // past (xEnd.yEnd)
        else sqrt((x - (this.x + vx * t)).sqr() + (y - (this.y + vy * t)).sqr()) // between (x,y) and (xEnd,yEnd)
        return dst <= hitDelta
    }
}

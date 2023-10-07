package ui.lectures.drawables.primitives

import javafx.scene.canvas.GraphicsContext
import kotlin.math.pow

abstract class Drawable(var x: Double, var y: Double,
                        protected val name: String) {

    abstract fun draw(gc: GraphicsContext)
    abstract fun isHit(x: Double, y: Double): Boolean

    override fun toString(): String {
        return name
    }
}

// Extension functions for Double
fun Double.between(low: Double, high: Double): Boolean {
    return this in low .. high
}

fun Double.sqr(): Double {
    return this.pow(2)
}
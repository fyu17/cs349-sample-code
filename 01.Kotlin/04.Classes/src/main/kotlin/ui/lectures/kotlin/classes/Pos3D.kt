package ui.lectures.kotlin.classes

import kotlin.math.sign

/**
 * Stores a position in 3D.
 * @param x the x-coordinate of the [Pos3D]
 * @param y the y-coordinate of the [Pos3D]
 * @param z the z-coordinate of the [Pos3D]
 */
class Pos3D(var x: Double, var y: Double, z: Double) { // The primary constructor for Pos3D; parameters x and y are also public variable members of Pos3D, z is a parameter

    /**
     * the z-coordinate of the [Pos3D]
     */
    var z = sign(z)          // public field z; initialized with the sign of parameter z
        get() = field        // public getter; not necessary in this example, just shown for completeness
        private set(value) { // private setter; limits z to the range [-1.0, ..., 4.0]
            field = value.coerceIn(-1.0, 4.0)
        }

    /**
     * zoom adds [factor] to [z]
     */
    fun zoom(factor: Double) {
        z += factor          // uses setter of z (see above)
    }

    override fun toString(): String { // Overrides the function "toString" from the parent class "Any"
        return "x: $x; y: $y; z: $z"
    }
}
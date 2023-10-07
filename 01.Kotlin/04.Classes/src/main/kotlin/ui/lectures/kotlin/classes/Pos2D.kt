package ui.lectures.kotlin.classes

import kotlin.math.sqrt

/**
 * Stores a position in 2D.
 * @param x the x-coordinate of the [Pos2D]
 * @param y the y-coordinate of the [Pos2D]
 */
class Pos2D(val x: Double, val y: Double) {              // The PRIMARY constructor for Pos2D; both parameters are also public value members of Pos2D

    // Indicates if the instance was created using the (secondary) copy-constructor.
    private var isCopy = false                           // Private member of Pos2D of type Boolean
    val length = sqrt(x * x + y * y)                  // Public member of Pos2D of type Double

    init {                                               // An initializer of the PRIMARY constructor
        println("x: $x; y: $y")
    }

    /**
     * Copies the [Pos2D] in [other].
     * @param other the Pos2D to be copied
     */
    constructor(other: Pos2D) : this(other.x, other.y) { // A SECONDARY constructor for Pos2D; it must call the primary constructor
        isCopy = true
    }

    /**
     * Returns a string representation of the [Pos2D].
     */
    override fun toString(): String {                    // Overrides the function "toString" from the (implicit) parent class "Any"
        return "x: $x; y: $y; isCopy?: $isCopy"
    }
}
package ui.lectures.kotlin.inheritance.position

import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Stores a position in 2D.
 * @param x the x-coordinate of the [Pos2D]
 * @param y the y-coordinate of the [Pos2D]
 */
open class Pos2D(protected var x: Double, protected var y: Double) {  // The primary constructor for Pos2D; both parameters are also protected value members of Pos2D, thus can be accessed by subclasses; the class is open, so it can be subclassed

    // The Euclidean distance from the origin
    protected open val euclidean = sqrt(x.pow(2) + y.pow(2)) // A protected member of Pos2D; it can be accessed ("protected") and overridden ("open") by subclasses

    init {                                                            // An initializer of the primary constructor
        println("x: $x; y: $y")
    }

    /**
     * Returns a string representation of the [Pos2D].
     */
    override fun toString(): String {                                 // Overrides the function "toString" from the parent class "Any"
        return "Distance from origin: $euclidean"
    }
}
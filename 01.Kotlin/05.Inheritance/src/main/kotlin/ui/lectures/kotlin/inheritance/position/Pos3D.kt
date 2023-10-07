package ui.lectures.kotlin.inheritance.position

import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Stores a position in 3D.
 * @param x the x-coordinate of the [Pos3D]
 * @param y the y-coordinate of the [Pos3D]
 * @param z the z-coordinate of the [Pos3D]
 */
open class Pos3D(x: Double, y: Double, z: Double = 0.0) : Pos2D(x, y) { // Inherits from Pos2D; class is open, so it can be subclassed; x, y, and z are parameters to the primary constructor

    // The Euclidean distance from the origin
    final override val euclidean = sqrt(x.pow(2) + y.pow(2) + z.pow(2)) // Overrides the protected member "euclidean" from the parent class Pos2D and disallows further overriding by subclasses ("final"); x, y, and z are the parameters of the primary constructor

    // The Manhattan distance from the origin
    private val manhattan = abs(super.x) + abs(super.y) + abs(z) // x and y are members in Pos2D, z is a parameter of the primary constructor

    init {                                                       // One initializer of the primary constructor
        println("x: ${super.x}; y: ${super.y}; z: $z")
    }

    /**
     * Returns a string representation of the [Pos3D].
     */
    override fun toString(): String {                            // Overrides the function "toString" from the parent class "Pos2D"
        return "Distance from origin: $euclidean or $manhattan"
    }
}
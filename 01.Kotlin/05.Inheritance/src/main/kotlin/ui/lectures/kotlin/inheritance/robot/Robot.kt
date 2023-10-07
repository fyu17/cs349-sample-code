package ui.lectures.kotlin.inheritance.robot

/**
 * Robot class hierarchy:
 * >abstract Robot<     interface Movable
 *           └─────────┐┌─────────┘
 *            abstract MoveRobot         interface Rotatable
 *        ┌────────────┘└────────────┐┌────────────┘
 *  class DropRobot            class RotateRobot
 */

/**
 * A robot located at coordinates [x] and [y].
 * @param x the x-coordinate of the robot
 * @param y the y-coordinate of the robot
 */
abstract class Robot(x: Int, y: Int) {

    /**
     * Returns the x-coordinate of the [Robot]
     */
    var x: Int = x
        protected set

    /**
     * Returns the y-coordinate of the [Robot]
     */
    var y: Int = y
        protected set

    /**
     * Performs an action.
     */
    abstract fun activate()

    /**
     * Returns a string representation of the [Robot].
     */
    override fun toString(): String {
        return "Robot at ($x,$y)"
    }
}
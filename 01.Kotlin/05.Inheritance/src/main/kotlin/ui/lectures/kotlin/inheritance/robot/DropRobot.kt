package ui.lectures.kotlin.inheritance.robot

/**
 * Robot class hierarchy:
 *  abstract Robot      interface Movable
 *           └─────────┐┌─────────┘
 *            abstract MoveRobot         interface Rotatable
 *        ┌────────────┘└────────────┐┌────────────┘
 * >class DropRobot<           class RotateRobot
 */

/**
 * A movable robot located at coordinates [x] and [y], which can drop [payload] units of payload.
 * @param x the x-coordinate of the robot
 * @param y the y-coordinate of the robot
 * @param payload the number of payload units available
 */
open class DropRobot(x: Int, y: Int, private var payload: Int) : MoveRobot(x, y) {

    /**
     * Drops one payload unit.
     */
    override fun activate() {
        if (payload > 0) {
            println("Dropping payload.")
            --payload
        }
    }

    /**
     * Returns a string representation of the [DropRobot].
     */
    override fun toString(): String {
        return "Robot at ($x,$y), payload units $payload"
    }
}
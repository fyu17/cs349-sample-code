package ui.lectures.kotlin.inheritance.robot

/**
 * Robot class hierarchy:
 *  abstract Robot      interface Movable
 *           └─────────┐┌─────────┘
 *            abstract MoveRobot         interface Rotatable
 *        ┌────────────┘└────────────┐┌────────────┘
 *  class DropRobot           >class RotateRobot<
 */

/**
 * A movable, rotatable robot located at coordinates [x] and [y], currently facing towards [dir].
 * @param x the x-coordinate of the robot
 * @param y the y-coordinate of the robot
 * @param dir the direction the robot is facing towards
 */
class RotateRobot(x: Int, y: Int, dir: Direction = Direction.UP) : MoveRobot(x, y), Rotatable {

    // the current direction the robot is facing
    private var orientation = dir

    /**
     * Rotates the robot 90 degrees right / clock-wise.
     */
    override fun rotateRight() {
        orientation = orientation.rotateRight()
    }

    /**
     * Moves the robot by one unit towards its current direction.
     */
    override fun moveForward() {
        x = when (orientation) {
            Direction.RIGHT -> x + 1
            Direction.LEFT -> x - 1
            else -> x
        }
        y = when (orientation) {
            Direction.UP -> y + 1
            Direction.DOWN ->  y - 1
            else -> y
        }
    }

    override fun activate() {
        println("No payload available.")
    }

    /**
     * Returns a string representation of the [RotateRobot].
     */
    override fun toString(): String {
        return "Robot at ($x,$y), facing ${orientation.name}"
    }
}
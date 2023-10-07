package ui.lectures.kotlin.inheritance.robot

/**
 * Robot class hierarchy:
 *  abstract Robot      interface Movable
 *           └─────────┐┌─────────┘
 *           >abstract MoveRobot<        interface Rotatable
 *        ┌────────────┘└────────────┐┌────────────┘
 *  class DropRobot            class RotateRobot
 */

/**
 * A movable robot located at coordinates [x] and [y].
 * @param x the x-coordinate of the robot
 * @param y the y-coordinate of the robot
  */
abstract class MoveRobot(x: Int, y: Int) : Robot(x, y), Movable { // Must be abstract since it does not implement Robot::activate.

    /**
     * Moves the robot forward by one unit.
     */
    override fun moveForward() {
        ++x
    }
}
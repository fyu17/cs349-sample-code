package ui.lectures.kotlin.inheritance.robot

/**
 * Robot class hierarchy:
 *  abstract Robot      interface Movable
 *           └─────────┐┌─────────┘
 *            abstract MoveRobot        >interface Rotatable<
 *        ┌────────────┘└────────────┐┌────────────┘
 *  class DropRobot            class RotateRobot
 */

/**
 * Indicates that the robot can rotate.
 */
interface Rotatable {

    /**
     * Rotates the robot right / clock-wise.
     */
    fun rotateRight()
}
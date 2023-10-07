package ui.lectures.kotlin.inheritance

import ui.lectures.kotlin.inheritance.position.Pos2D
import ui.lectures.kotlin.inheritance.position.Pos3D
import ui.lectures.kotlin.inheritance.robot.DropRobot
import ui.lectures.kotlin.inheritance.robot.RotateRobot

fun main() {

    // Examples for Pos2D and Pos3D
    val myPos2D = Pos2D(3.0, 4.0) // prints: "x: 3.0; y: 4.0"
    println(myPos2D)                    // prints: "Distance from origin: 5.0"

    val myPos3D = Pos3D(3.0, 4.0, 12.0) // prints: "x: 3.0; y: 4.0"; from init in Pos2D
                                                 //         "x: 3.0; y: 4.0; z: 12.0"; from init in Pos3D
    println(myPos3D)                             // prints: "Distance from origin: 13.0 or 19.0"

    val anonPos = object: Pos2D(6.0, 8.0) { // declaring and instantiating an anonymous class that inherits from Pos2D
        var w = 2.0                               // property of the anonymous class
        override fun toString(): String {         // Overrides the function "toString" from the parent class "Pos2D"
            return "Distance from origin: ${euclidean / w}"
        }
    }
    println(anonPos) // prints: "(3.0,4.0)"

    // Examples for Robots
    /*val myDropRobot = DropRobot(0, 0, 3)
    println(myDropRobot)   // prints: "Robot at (0,0), payload units 3"
    myDropRobot.activate() // prints: "Dropping payload."
    println(myDropRobot)   // prints: "Robot at (0,0), payload units 2"

    val myRotateRobot = RotateRobot(0, 3)
    println(myRotateRobot)      // prints: "Robot at (0,3), facing UP"
    myRotateRobot.rotateRight()
    println(myRotateRobot)      // prints: "Robot at (0,3), facing RIGHT"
    myRotateRobot.moveForward()
    println(myRotateRobot)      // prints: "Robot at (1,3), facing RIGHT"*/
}
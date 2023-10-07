package ui.lectures.kotlin.strings

import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

class Pos(val x: Double, val y: Double)

fun main() {
    var myString = "CS349!" // myString is "CS349!"
    println(myString[1])    // prints: "S"
    // strings are immutable, i.e., changing it like this: myString[2] = '4' does not work
    myString = "CS449!"              // myString is now "CS449!"

    // There are numerous functions for manipulating strings; here are just a few examples
    // Since strings are immutable, all these functions return a new string!
    println(myString.lowercase())    // prints: "cs449"
    println(myString.drop(2))     // also "dropLast"; prints: "449!"
    println(myString.takeLast(4)) // also "take"; prints: "449!"
    println(myString.slice(2..4)) // prints: "449"

    // The function .format works in a similar fashion than, for example, printf in C.
    val myPi = 3.1415
    println("Pi is: %.2f (or more precise: %.6f)".format(myPi, PI)) // prints: "Pi is: 3.14 (or more precise: 3.141593)"

    // String templates allow to add expressions into strings by using $ or ${}.
    println("The value of myPi is $myPi")        // prints: "The value of myPi is 3.1415"
    println("The value of Rho is ${2.0 * myPi}") // prints: "The value of Rho is 6.283"

    val myPos = Pos(3.0, 4.0)
    println("My location is (${myPos.x}, ${myPos.y})") // prints: "My location is (3.0, 4.0)"
    println("My distance is ${sqrt(myPos.x.pow(2) + myPos.y.pow(2))}") // prints: "My distance is 5.0"
}
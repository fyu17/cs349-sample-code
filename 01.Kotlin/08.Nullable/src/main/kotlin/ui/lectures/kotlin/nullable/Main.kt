package ui.lectures.kotlin.nullable

import kotlin.math.PI
import kotlin.math.log2
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.random.Random

class Pos(val x: Double, val y: Double) {
    val length = sqrt(x.pow(2) + y.pow(2))
    override fun toString(): String {
        return "($x,$y)"
    }
}

fun maybeMakePos(x: Double, y: Double) : Pos? {
    return if (Random.nextBoolean()) Pos(x, y) else null
}

fun alwaysMakePos(x: Double, y: Double) : Pos? {
    return Pos(x, y)
}

fun main() {

    var myInt = 349 // myInt is of type "Int"
    // myInt cannot be "null" because "Int" is not a nullable type: "myInt = null" does not work

    var myNullableInt: Int? = 349 // myNullableInt is of type "Int?", i.e., "Nullable Int"
    myNullableInt = null

    var myLocation: Pos? = null // the type of data that is initialized to "null" must be explicitly declared
    myLocation = Pos(3.0, 4.0)

    myLocation = maybeMakePos(4.0, 3.0)
    println(myLocation?.length) // Using the safe-call operator "?."; prints: either "5.0" or "null"
    println(myLocation?.length ?: Double.NaN) // Using the ternary operator "?:"; prints: either "5.0" or "NaN"

    myLocation = alwaysMakePos(4.0, 3.0)
    myLocation!! // Using the non-null assertion operator "!!" to convert a nullable type (here: Pos?) to its corresponding non-nullable type (here: Pos)
    println(myLocation.length) // prints: "5.0"
    myLocation = alwaysMakePos(4.0, 3.0) // re-assigning "myLocation", Kotlin assumes that its value could be "null" again
    println("(${myLocation!!.x},${myLocation!!.y})") // prints: "(4.0,3.0)", using the non-null assertion operator "!!"
}
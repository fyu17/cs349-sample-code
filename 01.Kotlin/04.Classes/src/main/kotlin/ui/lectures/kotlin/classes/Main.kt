package ui.lectures.kotlin.classes

fun main() {

    val myPos = Pos()
    println(myPos) // prints something similar to: "ui.lectures.kotlin.classes.Pos@7a81197d"

    val myPos2D = Pos2D(3.0, 4.0)             // instantiating a Pos2D object using the PRIMARY constructor
    println("(x,y) -> (${myPos2D.x},${myPos2D.y})") // accessing a public member of Pos2; prints: "(x,y) -> (3.0,4.0)"
    println("Length is ${myPos2D.length}")          // accessing a public member of Pos2; prints: "Length is 5.0"
    println(myPos2D)                                // implicit call to Pos2D::toString(); prints: "x: 3.0; y: 4.0; isCopy?: false"

    val myPos2DCopy = Pos2D(myPos2D)                // instantiating a Pos2D object using a SECONDARY constructor
    println(myPos2DCopy)                            // prints: "x: 3.0; y: 4.0; isCopy?: true"

    val myPos3D = Pos3D(3.0, 5.0, -10.0)
    println(myPos3D)                                          // prints: "x: 3.0; y: 5.0; z: -1.0"
    println("Length is ${myPos3D.x + myPos3D.y + myPos3D.z}") // prints: "Length is 7.0"
    myPos3D.zoom(20.0)
    println("Length is ${myPos3D.x + myPos3D.y + myPos3D.z}") // prints: "Length is 12.0"
    myPos3D.x = myPos3D.y                                     // possible because Pos3D.x is a variable
    println("Length is ${myPos3D.x + myPos3D.y + myPos3D.z}") // prints: "Length is 14.0"

    val anonPos = object { // declaring and instantiating an anonymous class
        var x = 3.0        // properties of the anonymous class
        var y = 4.0
        fun reset() {      // a function of the anonymous class
            x = 1.0
            y = 1.0
        }
        override fun toString(): String { // Overrides the function "toString" from the (implicit) parent class "Any"
            return "($x,$y)"
        }
    }
    // An anonymous class behaves like a "regular" class. The only difference is that they do not have constructors, so there cannot be a second instance of a particular anonymous class.
    println(anonPos) // prints: "(3.0,4.0)"
    anonPos.reset()
    println("anonPos: x + y = ${anonPos.x + anonPos.y}") // prints: "anonPos: x + y = 2.0"
}
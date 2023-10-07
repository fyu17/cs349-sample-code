package ui.lectures.kotlin.data

fun main() {

    // ========================================================================
    // Immutable data (values), i.e., constants

    val c: Int = 349 // declaration & assignment
    val d = 349      // type is inferred and therefore optional (inferred: Int)
    // d = 449       // compile-time error: val cannot be reassigned

    val e: Int       // declaration only, type is required
    e = 349          // deferred assignment
    // e = 449       // compile-time error: val cannot be reassigned
    // e = "449"     // compile-time error: val cannot be reassigned & type mismatch

    // ========================================================================
    // Mutable data, i.e., variables
    var i: Int = 349 // declaration & assignment
    var j = 349      // type is optional (inferred: Int)
    var b = true     // type is optional (inferred: Boolean)
    var k: Int       // declaration only: type is required
    k = 349
    k = 449          // reassigning value to k
}
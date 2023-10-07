package ui.lectures.kotlin.collections

import kotlin.math.PI
import kotlin.math.log2
import kotlin.math.pow
import kotlin.math.sqrt

class Pos(val x: Double, val y: Double) {
    val length = sqrt(x.pow(2) + y.pow(2))
    override fun toString(): String {
        return "($x,$y)"
    }
}

fun main() {
    // Immutable collections
    val myImmutableList = listOf("A", "B", "C", "A", "D")
    println(myImmutableList) // prints: "[A, B, C, A, D]"
    val myImmutableSet = setOf("A", "C", "B", "A", "D")
    println(myImmutableSet)  // prints: "[A, C, B, D]"
    val myImmutableMap = mapOf(0 to "A", 1 to "B", 3 to "D", 19 to "S")
    println(myImmutableMap)  // prints: "{0=A, 1=B, 3=D, 19=S}"

    // Mutable collections
    val myMutableList = mutableListOf("A", "B", "C", "A", "D")
    val myMutableSet = mutableSetOf("A", "B", "C", "A", "D")
    val myMutableMap = mutableMapOf(0 to "A", 1 to "B", 3 to "D", 19 to "S")

    // Empty collections (example for MutableList only, other collections work the same)
    val myEmptyList = mutableListOf<String>()

    // Generating list (example for MutableList only, other collections work the same)
    val myGeneratedAlphabet = MutableList(26) { ('A' + it).toString() }
    println(myGeneratedAlphabet)   // prints: "[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]"
    val myGeneratedLogarithms = MutableList(9) { log2(it.toDouble()) }
    println(myGeneratedLogarithms) // prints: "[-Infinity, 0.0, 1.0, 1.584..., 2.0, 2.321..., 2.584..., 2.807..., 3.0]"

    // Lists
    val animals = mutableListOf("ape", "beaver", "camel")
    println(animals[2])                 // prints: "camel"
    println(animals.indexOf("beaver"))  // prints: "1"
    println(animals.size)               // prints: "3"
    animals.forEach { println(it) }     // prints: "ape", "beaver", "camel"
    animals.removeAt(0)           // removing element by index
    animals.remove("camel")     // removing element
    println(animals)                    // prints: "[beaver]"
    animals.add("comoran")              // adding element to the end
    animals.add(0, "ant") // adding element at index
    println(animals)                    // prints: "[ant, beaver, comoran]"

    // Sets
    val set1 = setOf(1, 1, 2, null)
    println(set1)                 // prints: "[1, 2, null]"; the second "1" is disregarded
    val set2 = setOf(1, 2, null, null, null)
    println(set2)                 // prints: "[1, 2, null]"; the second and third "null" are disregarded
    val set3 = mutableSetOf(1, 2, 3, 1)
    println(set3)                 // prints: "[1, 2, 3]"; the second "1" is disregarded
    println(set1 == set2)         // prints: "true"
    println(set1 == set3)         // prints: "false"
    println(set1.union(set3))     // prints: "[1, 2, null, 3]"
    println(set1.intersect(set3)) // prints: "[1, 2]"
    println(set1.minus(set2))     // prints: "[]"

    // Maps
    val langs =mutableMapOf("135" to "Racket", "136" to "C", "349" to "Kotlin")
    println(langs["346"])   // prints: "null", since key "346" does not exist
    println(langs["349"])   // prints: "Kotlin"
    langs["246"] = "C++"    // adds "246 to C++" to "langs" since key "246" does not exist
    langs["135"] = "Python" // overwrites value "Racket" for key "136" with "Python"
    println(langs)          // prints: {135=Python, 136=C, 349=Kotlin, 246=C++}

    // There are numerous higher-order functions for processing collections; here are just a few examples
    // All these functions return a new collection!
    (0..4).filter { it % 2 == 0 } // "filter" only includes elements that satisfy the predicate; yields: "[0, 2, 4]"

    // map transforms data from a collection
    (0..4).map { it * 2 }         // yields: "[0, 2, 4, 6, 8]", doubling the values of the range (0..4)
    animals.map { it.length }           // yields: "[3, 6, 5]", the length of each of the strings in "animals"
    (1..4).map { "a".repeat(it) } // yields: "[a, aa, aaa, aaaa]", repeats "a" (1..4) times

    // fold and reduce fold a collection
    (0..4).fold(0) { acc, elem -> acc + elem }           // yields: "10", summing all elements in (0..4), with initial accumulator value "0"
    (0..4).fold("string: ") { acc, elem -> "$acc$elem" } // yields: "string: 01234", concatenating all elements in (0..4), with initial accumulator value "string: "
    (0..4).reduce { acc, elem -> acc + elem }                  // yields: "10", summing all elements in (0..4), with initial accumulator value "0"

    // forEach and onEach traverse a collection
    (0..4).forEach { print(it) }                                           // prints: "01234", yields: Unit
    val range = (0..4).onEach { print(it) }.toMutableList() // prints: "01234", yields: (0..4)

    // partition splits a collection into two collections: one for which the predicate yields true, and one for which it yields false
    val (even, odd) = (0..4).partition { it % 3 == 0 } // yields: "[0, 2, 4], [1, 3]"
    println(even) // prints: "[0, 2, 4]"
    println(odd)  // prints: "[1, 3]"

    // some more complex higher-order function usages:
    var factors = (0..10).groupBy { it % 3 }  // contains: {0=[0, 3, 6, 9], 1=[1, 4, 7, 10], 2=[2, 5, 8]}
    var step2String = List(13) { it }.map {it * 2 }.map { ('a' + it).toString() }.reduce { acc, cur -> "$acc$cur"} // contains: "acegikmoqsuwy]", creates a list with (0..13)), doubles all values, adds them to "a", and reduces them to a single string

    var coord = mapOf(0 to Pos(0.0, 0.0),
        1 to Pos(3.0, 6.0),
        4 to Pos(2.0, 1.0),
        9 to Pos(1.0, 9.0),
        2 to Pos(5.0, 3.0),
        7 to Pos(7.0, 5.0))

    // keeps all Pos objects that are further away from the origin than the average
    println(coord.filter { it.value.length >= (coord.values.sumOf { it.length } / coord.size) })                 // second "it" shadows first "it" (not a problem in this example)
    println(coord.filter { pos -> pos.value.length >= (coord.values.sumOf { sum -> sum.length } / coord.size) }) // naming variables explicitly avoids shadowing
}
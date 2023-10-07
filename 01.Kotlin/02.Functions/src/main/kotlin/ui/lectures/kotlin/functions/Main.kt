package ui.lectures.kotlin.functions

/**
 * Returns the meaning of life.
 */
fun meaning(): Int { // parameter list: empty / return type: Int
    return 42
}

/**
 *  Prints the sum of [a] and [b] to the console.
 *  @param a the first summand
 *  @param b the second summand
 */
fun sum(a: Int, b: Int): Unit {   // return type is optional if it is Unit (i.e., "void").
    println("$a + $b = ${a + b}") // string template (see xx.Strings)
}

/**
 * Returns the increment of [i] by [n].
 * @param i the base integer
 * @param n the increment, default is 1
 */
fun addn(i: Int, n: Int = 1): Int { // n has default value 1
    print("add$n($i) ")             // string template (see xx.Strings)
    return i + n
}

/**
 * Returns the sum of all parameter values.
 * For alternative implementations, see xx.Loops and xx.hof
 */
fun sum(vararg numbers: Int): Int {
    var sum = 0
    for (number in numbers) {
        sum += number
    }
    println("The sum is $sum.")
    return sum
}

fun main() {

    val m = 349
    val n = meaning()          // n is now 42

    sum(m, n)                      // call to sum(Int, Int); prints: "349 + 42 = 391"
    sum(m)                         // call to sum(varargs ..); prints: "The sum is 349."
    sum(m, m, m)                   // call to sum(varargs ..); prints: "The sum is 1047."

    val x = addn(m, n)         // prints: "add42(349)"
    println(x)                     // prints: "391"

    val y = addn(m)            // uses default value (1) for n; prints: "add1(349)"
    println(y)                     // prints: "350"

    val z = addn(n = m, i = n) // naming parameters; prints: "add349(42)"
    println(z)                     // prints: "391"
}
package ui.lectures.kotlin.lambda

/**
 * Prints [i] if it satisfied the predicate [pred].
 * @param i integer to be printed
 * @param pred function "pointer" to predicate
 */
fun printif(i: Int, pred: (Int) -> Boolean) { // "i" is of type "Int", "pred" is of type "(Int) -> Boolean"
    if (pred(i)) {
        println(i)
    }
}

fun isEven(n: Int) : Boolean {
    return n % 2 == 0
}

fun main() {

    val m = 349

    printif(m + 1, ::isEven)

    // declaration and definition of lambda function "isOdd"
    val isOdd: (Int) -> Boolean = {  // this value has the identifier "isOdd" and is of type "(Int) -> Boolean"
            n: Int ->                // parameter list
        n % 2 == 1                   // instead of "returning" a value, lambda functions "yield" a value
    }
    println(isOdd(m))                // prints: "true"

    // passing a LAMDBA FUNCTION ("isOdd") as parameter into printif
    printif(m, isOdd)                // prints: "349"

    // passing an ANONYMOUS FUNCTION as parameter into printif
    //   if the LAST parameter of a higher-order-function is a function, it can be declared anonymously
    //   for example, it works for "fun printif(n: Int, pred: (Int) -> Boolean)", but not for "fun printif(pred: (Int) -> Boolean, n: Int)"
    printif(m + 10) { n: Int ->   // prints: "359"
        (300 <= n) and (n <= 399)
    }

    // passing an ANONYMOUS FUNCTION as parameter into printif
    //   if the anonymous function has one parameter only, it does not have to be named and instead is called "it"
    //   for example, it works for "fun printif(n: Int, pred: (Int) -> Boolean)", but not for "fun printif(m: Int, n: Int, pred: (Int) -> Boolean)"
    printif(m + 20) {        // prints: "369"
        (300 <= it) and (it <= 399)
    }

    // declaration and definition of lambda function "isBetween" that yields an anonymous function of type "(Int) -> Boolean"
    val isBetween: (Int, Int) -> ((Int) -> Boolean) = {
        low: Int, high: Int -> {                   // parameter list of lambda function "isBetween"
            n: Int -> (low <= n) and (n <= high) } // yielded value; type: "(Int) -> Boolean", i.e., an anonymous function
    }

    // calling printif where the anonymous function returned by "isBetween(300, 399)" is used as second parameter
    printif(m + 30, isBetween(300, 399))        // prints: "379"

    // calling printif where the yielded value of the call "isBetween(300, 399)(it)" is used in printif
    printif(m + 40) { isBetween(300, 399)(it) } // prints: "389"
}
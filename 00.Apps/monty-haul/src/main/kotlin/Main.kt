import kotlin.random.Random
import kotlin.random.nextInt

// Simulation based on the Monty Haul problem
// https://en.wikipedia.org/wiki/Monty_Hall_problem

fun main() {
    var countPlayerDoor = 0
    var countOtherDoor = 0
    val iterations = 1_000_000

    repeat (iterations) {
        // let's assume three doors, as in the classic description of this scenario
        val doors = mutableListOf("Goat", "Goat", "Goat")

        // randomly place the car behind one of the doors
        val position = Random.nextInt(0..2)
        doors[position] = "Car"

        // we pick the first door

        // Monty reveals either door 2 or 3, whichever one has a goat
        // the car must then be behind our door, or the remaining door
        if (doors[1] == "Goat") {
            doors.removeAt(1)
        } else {
            doors.removeAt(2)
        }

        // is the goat behind door 1 or 2?
        if (doors[0] == "Car") {
            countPlayerDoor++
        } else {
            countOtherDoor++
        }
    }

    // display final stats based on # of iterations
    println("Player door: ${countPlayerDoor*100f/iterations}")
    println("Other door: ${countOtherDoor*100f/iterations}")
}
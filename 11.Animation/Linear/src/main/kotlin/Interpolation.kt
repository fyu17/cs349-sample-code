/*
 * Linear interpolation from start to end, using
 * time factor t (t should be in [0, 1])
 */
fun lerp(start: Double, end: Double, t: Double): Double {
    return start + (end - start) * t
}

/*
 * Track interpolated values over time
 */
class Interpolation(
    val startValue: Double, // starting value (keyframe 1)
    val endValue: Double,   // ending value (keyframe 2)
    val duration: Long,     // time is duration (in ms)
) {
    // current value
    var currentValue: Double = startValue
        private set

    // use null as the not running flag
    private var startTime: Long? = null

    fun start() {
        // get start time
        startTime = System.nanoTime()
        // initialize calculated value
        currentValue = startValue
    }

    fun update(currentTime: Long): Double {
        // check if animation is running
        if (startTime != null) {
            // elapsed time (converted to milliseconds)
            val elapsed = (currentTime - (startTime ?: 0)) / 1e6
            // proportion of time completed
            val t = elapsed / duration
            // interpolate value
            currentValue = lerp(startValue, endValue, t)

            // if animation ended
            if (elapsed > duration) {
                currentValue = endValue // snap to final value
                startTime = null
            }
        }
        return currentValue
    }
}
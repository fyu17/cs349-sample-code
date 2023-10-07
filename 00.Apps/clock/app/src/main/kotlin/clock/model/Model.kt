package clock.model

import clock.view.IView
import javafx.animation.AnimationTimer
import java.util.*

class Model {
    var timer: AnimationTimer
    val views = mutableListOf<IView>()
    val hour: Int
        get() = Calendar.getInstance()[Calendar.HOUR_OF_DAY]
    val minute
        get() = Calendar.getInstance()[Calendar.MINUTE]
    val second
        get() = Calendar.getInstance()[Calendar.SECOND]
    val date: Date
        get() = Date()

    init {
        timer = object : AnimationTimer() {
            override fun handle(now: Long) {
                for (view in views) {
                    view.update()
                }
            }
        }
    }

    fun start() = timer.start()
    fun stop() = timer.stop()
}
package clock.view

import clock.model.Model
import javafx.scene.Group
import javafx.scene.control.Label
import javafx.scene.text.Font
import java.text.SimpleDateFormat

class TimeView(val model: Model) : Group(), IView {
    val time = Label()

    init {
        time.font = Font("Helvetica", 28.0)
        this.children.add(time)
    }

    override fun update() {
        time.text = SimpleDateFormat("hh:mm:ss").format(model.date)
    }
}
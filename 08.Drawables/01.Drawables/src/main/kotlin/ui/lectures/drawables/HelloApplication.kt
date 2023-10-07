package ui.lectures.drawables

import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color
import javafx.stage.Stage
import ui.lectures.drawables.primitives.*

class HelloDrawables : Application() {

    override fun start(stage: Stage) {

        // ↓↓↓ Drawing using Canvas, graphicsContext2D, and Drawables ↓↓↓
        val myDrawables = listOf(
            FillCirc(0.0, 0.0, 50.0, Color.GREEN, "Green Filled Circle"),
            StrokeCirc(100.0, 0.0, 50.0, 1.0, Color.PURPLE, 10.0,"Purple Stroke Circle"),
            FillRect(0.0, 100.0, 50.0, 25.0, Color.GREEN, "Green Filled Rectangle"),
            StrokeRect(100.0, 100.0, 50.0, 25.0, 6.0, Color.PURPLE, 6.0,"Purple Stroke Rectangle"),
            StrokeLine(25.0, 225.0, 75.0, 275.0, 5.0, Color.ORANGE, 15.0, "Orange Stroke / Line")
        )

        val myCanvas = Canvas(480.0, 320.0).apply {
            myDrawables.forEach {
                it.draw(graphicsContext2D)
            }
            onMouseClicked = EventHandler { me ->
                myDrawables.forEach {
                    if (it.isHit(me.x, me.y)) println(it)
                }
            }
        }
        // ↑↑↑ Drawing using Canvas, graphicsContext2D, and Drawables ↑↑↑

        stage.apply {
            title = "Hello CS349! - JavaFX.Drawables"
            scene = Scene(Group(myCanvas), myCanvas.width, myCanvas.height).apply {
            }
        }.show()
    }
}
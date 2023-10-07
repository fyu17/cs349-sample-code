package ui.lectures.javafx.drawing.arcs

import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color
import javafx.scene.shape.Arc
import javafx.scene.shape.ArcType
import javafx.scene.transform.Transform
import javafx.stage.Stage

class HelloArcs : Application() {
    override fun start(stage: Stage) {

        // ↓↓↓ Drawing using Canvas & graphicsContext2D ↓↓↓
        val myCanvas = Canvas(320.0, 320.0)
        myCanvas.graphicsContext2D.apply {

            // Top-left corner: 10,10; Width/Height: 75,75; starting at 0 degrees (right); extending for 135 degrees (CCW); open arc
            strokeArc(10.0, 10.0, 75.0, 75.0, 0.0, 135.0, ArcType.OPEN)
            // Top-left corner: 110,10; Width/Height: 75,75; starting at 0 degrees (right); extending for 105 degrees (CCW); round arc
            strokeArc(110.0, 10.0, 75.0, 75.0, 0.0, 105.0, ArcType.ROUND)
            // Top-left corner: 210,10; Width/Height: 75,75; starting at 0 degrees (right); extending for 90 degrees (CCW); chorded arc
            strokeArc(210.0, 10.0, 75.0, 75.0, 0.0, 90.0, ArcType.CHORD)

            // Top-left corner: 10,110; Width/Height: 75,75; starting at 0 degrees (right); extending for 135 degrees (CCW); round arc
            strokeArc(10.0, 110.0, 75.0, 75.0, 0.0, 135.0, ArcType.ROUND)
            // Top-left corner: 110,110; Width/Height: 75,75; starting at 45 degrees (top-right); extending for 90 degrees (CCW); round arc
            strokeArc(110.0, 110.0, 75.0, 75.0, 45.0, 90.0, ArcType.ROUND)

            // Top-left corner: 10,210; Width/Height: 75,75; starting at 45 degrees (top-right); extending for 270 degrees (CCW); round arc
            fill = Color.YELLOW   // setting fill colour to Color.YELLOW
            stroke = Color.ORANGE // setting stroke (= line) colour to Color.ORANGE
            lineWidth = 3.0       // setting line width to 3
            fillArc(10.0, 210.0, 75.0, 75.0, 45.0, 270.0, ArcType.ROUND)   // this draws the AREA of the arc
            strokeArc(10.0, 210.0, 75.0, 75.0, 45.0, 270.0, ArcType.ROUND) // this draws the OUTLINE of the arc

            stroke = Color.BLACK // setting stroke (= line) colour to Color.BLACK
            lineWidth = 1.0      // setting line width to 1

            // This draws a full circle made up of 4 arcs; starting at (22.5, 112.5, 202.5, 292.5) degrees; each extending for 90 degrees; fill colours are (red, yellow, green, blue).
            val fillColors = listOf(Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE)
            (0 .. 3).forEach {
                fill = fillColors[it]
                strokeArc(110.0, 210.0, 75.0, 75.0, it * 90.0 + 22.5, 90.0, ArcType.ROUND) // this just draws the outline
                fillArc(110.0, 210.0, 75.0, 75.0, it * 90.0 + 22.5, 90.0, ArcType.ROUND)   // this just draws the outline
            }
        }
        // ↑↑↑ Drawing using Canvas & graphicsContext2D ↑↑↑

        // ↓↓↓ Drawing using convenience class Line ↓↓↓
        // Three fundamental differences to Canvas & graphicsContext2D:
        // * First two parameters are centerX and centerY and NOT x and y (i.e., top-left corner)
        // * Next two parameters are radiusX and radiusY and NOT width and height
        // * Arcs are by filled and have no outline; to achieve the same effect as strokeArc0 the fields, fill, stroke, and strokeWidth must be set manually
        val myArcs = mutableListOf(
            Arc(47.5, 47.5, 37.5, 37.5, 0.0, 135.0).apply {
                fill = Color.TRANSPARENT
                strokeWidth = 1.0
                stroke = Color.BLACK
                type = ArcType.OPEN
            },
            Arc(147.5, 47.5, 37.5, 37.5, 0.0, 135.0).apply {
                fill = Color.TRANSPARENT
                strokeWidth = 1.0
                stroke = Color.BLACK
                type = ArcType.ROUND
            },
            Arc(247.5, 47.5, 37.5, 37.5, 0.0, 135.0).apply {
                fill = Color.TRANSPARENT
                strokeWidth = 1.0
                stroke = Color.BLACK
                type = ArcType.CHORD
            },
            Arc(47.5, 147.5, 37.5, 37.5, 0.0, 135.0).apply {
                fill = Color.TRANSPARENT
                strokeWidth = 1.0
                stroke = Color.BLACK
                type = ArcType.ROUND
            },
            Arc(147.5, 147.5, 37.5, 37.5, 45.0, 90.0).apply {
                fill = Color.TRANSPARENT
                strokeWidth = 1.0
                stroke = Color.BLACK
                type = ArcType.ROUND
            },
            Arc(47.0, 247.5, 37.5, 37.5, 45.0, 270.0).apply {
                fill = Color.YELLOW
                stroke = Color.ORANGE
                strokeWidth = 3.0
                type = ArcType.ROUND
                onMouseClicked = EventHandler {
                    println("Waka waka!")
                }
            }
        )

        // This draws a full circle made up of 4 arcs; starting at (22.5, 112.5, 202.5, 292.5) degrees; each extending for 90 degrees; fill colours are (red, yellow, green, blue).
        val fillColors = listOf(Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE)
        (0 .. 3).forEach {
            myArcs.add(Arc(147.5, 247.5, 37.5, 37.5, it * 90.0 + 22.5, 90.0).apply {
                fill = fillColors[it]
                stroke = Color.BLACK
                strokeWidth = 1.0
                type = ArcType.ROUND
                onMouseClicked = EventHandler { _ ->
                    println("Arc no #$it")
                }
                // WARNING: below is an (intentionally!) naive and basic implementation of highlighting, which can lead to flickering, depending on the mouse position
                onMouseEntered = EventHandler { _ ->
                    // removing all previous transforms
                    transforms.clear()
                    // the direction of the arc is its original startAngle (it * 90.0 + 22.5) plus half its length (90.0 / 2.0)
                    val direction = it * 90.0 + 22.5 + 90.0 / 2.0
                    // moving the arc away from the centre of the circle by (1) rotating it so that it is aligned with the x-axis, (2) moving along the x-axis by 10 units, and (3) rotating it back
                    transforms.addAll(Transform.rotate(-direction, centerX, centerY), Transform.translate(10.0, 0.0), Transform.rotate(direction, centerX, centerY))
                }
                onMouseExited = EventHandler {
                    // removing all previous transforms
                    transforms.clear()
                }
            })
        }
        // ↑↑↑ Drawing using convenience class Line ↑↑↑

        //val content = myCanvas // comment in for using Canvas & graphicsContext2D
        val content = myArcs.toList() // comment in for using convenience class Line; must be converted into an immutable list

        stage.apply {
            title = "Hello CS349! - JavaFX.Drawing.Lines"
            scene = Scene(Group(content), myCanvas.width, myCanvas.height).apply {
            }
        }.show()
    }
}
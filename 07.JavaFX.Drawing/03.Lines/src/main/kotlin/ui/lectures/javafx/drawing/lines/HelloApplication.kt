package ui.lectures.javafx.drawing.lines

import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color
import javafx.scene.shape.Line
import javafx.scene.shape.StrokeLineCap
import javafx.stage.Stage

class HelloLines : Application() {
    override fun start(stage: Stage) {

        // ↓↓↓ Drawing using Canvas & graphicsContext2D ↓↓↓
        val myCanvas = Canvas(320.0, 240.0)
        myCanvas.graphicsContext2D.apply {
            strokeLine(10.0, 10.0, 110.0, 110.0) // drawing a line from (10,10) to (110, 110) with default graphics context
            stroke = Color.PINK                                 // setting the stroke (= line) colour to Color.PINK
            strokeLine(30.0, 10.0, 130.0, 110.0)
            lineWidth = 4.0                                     // setting the line width to 4 units
            strokeLine(50.0, 10.0, 150.0, 110.0)

            lineCap = StrokeLineCap.SQUARE                      // setting line cap to StrokeLineCap.SQUARE
            lineWidth = 12.0                                    // setting the line width to 12 units
            stroke = Color.DARKGREEN                            // setting the stroke (= line) colour to Color.DARKGREEN
            strokeLine(90.0, 10.0, 140.0, 60.0)

            lineWidth = 1.0                                     // setting the line width to 1 unit
            setLineDashes(10.0, 5.0)                            // setting dashes to [10 units of line, 5 units of blank space], repeat
            strokeLine(130.0, 10.0, 230.0, 110.0)

            setLineDashes(10.0, 5.0, 20.0, 10.0)                // setting dashes to [10 units of line, 5 units of blank space, 20 units of line, 10 units of blank space], repeat
            strokeLine(150.0, 10.0, 250.0, 110.0)

            lineCap = StrokeLineCap.ROUND                       // setting line cap to StrokeLineCap.ROUND
            lineWidth = 4.0                                     // setting the line width to 4 unit
            setLineDashes(0.0, 10.0)                            // creating a dotted line by using StrokeLineCap.ROUND and 0.0 unis of line
            strokeLine(170.0, 10.0, 270.0, 110.0)
        }
        // ↑↑↑ Drawing using Canvas & graphicsContext2D ↑↑↑

        // ↓↓↓ Drawing using convenience class Line ↓↓↓
        val myLines = listOf(
            Line(10.0, 10.0, 110.0, 110.0), // drawing a line from (10,10) to (110, 110) with default field values
            Line(30.0, 10.0, 130.0, 110.0).apply {
                stroke = Color.PINK                                 // setting the stroke (= line) colour to Color.PINK
            },
            Line(50.0, 10.0, 150.0, 110.0).apply {
                stroke = Color.PINK
                strokeWidth = 4.0                                   // setting the stroke (= line) width to 4 units
            },
            Line(90.0, 10.0, 140.0, 60.0).apply {
                stroke = Color.DARKGREEN
                strokeLineCap = StrokeLineCap.SQUARE                // setting stroke (= line) cap to StrokeLineCap.SQUARE
                strokeWidth = 12.0
                onMouseClicked = EventHandler {        // Adding a mouse event handler for MouseClicked to the line.
                    println("Mouse clicked on thick line!")         // !!! THIS IS DIFFERENT FROM THE EXAMPLE ABOVE !!!
                }
            },
            Line(130.0, 10.0, 230.0, 110.0).apply {
                stroke = Color.DARKGREEN
                strokeLineCap = StrokeLineCap.SQUARE
                strokeDashArray.addAll(10.0, 5.0)         // setting dashes to [10 units of line, 5 units of blank space], repeat
            },
            Line(150.0, 10.0, 250.0, 110.0).apply {
                stroke = Color.DARKGREEN
                strokeLineCap = StrokeLineCap.SQUARE
                strokeDashArray.addAll(10.0, 5.0, 20.0, 10.0) // setting dashes to [10 units of line, 5 units of blank space, 20 units of line, 10 units of blank space], repeat
            },
            Line(170.0, 10.0, 270.0, 110.0).apply {
                stroke = Color.DARKGREEN
                strokeLineCap = StrokeLineCap.ROUND
                strokeWidth = 4.0                                   // setting the stroke (= line) width to 4 units
                strokeDashArray.addAll(0.0, 10.0)         // creating a dotted line by using StrokeLineCap.ROUND and 0.0 unis of line
            }
        )
        // ↑↑↑ Drawing using convenience class Line ↑↑↑

        val content = myCanvas // comment in for using Canvas & graphicsContext2D
        //val content = myLines // comment in for using convenience class Line

        stage.apply {
            title = "Hello CS349! - JavaFX.Drawing.Lines"
            scene = Scene(Group(content), myCanvas.width, myCanvas.height).apply {
            }
        }.show()
    }
}
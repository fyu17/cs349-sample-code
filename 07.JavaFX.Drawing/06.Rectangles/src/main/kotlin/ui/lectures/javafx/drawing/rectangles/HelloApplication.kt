package ui.lectures.javafx.drawing.rectangles

import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color
import javafx.scene.shape.*
import javafx.stage.Stage

class HelloRectangles : Application() {
    override fun start(stage: Stage) {

        // ↓↓↓ Drawing using Canvas & graphicsContext2D ↓↓↓
        val myCanvas = Canvas(480.0, 480.0)
        myCanvas.graphicsContext2D.apply {
            // Outline; top-left corner: 10,10; Width/Height: 100,50
            strokeRect(10.0, 10.0, 100.0, 50.0)
            // Filled; top-left corner: 130,10; Width/Height: 100,50
            fillRect(130.0, 10.0, 100.0, 50.0)
            stroke = Color.DEEPPINK // set stroke (= line) color to Color.DEEPPINK
            // Outline; top-left corner: 250,10; Width/Height: 100,50; Rounded corners 40,20
            strokeRoundRect(250.0, 10.0, 100.0, 50.0, 40.0, 20.0)
            fill = Color.ORANGE // set fill color to Color.ORANGE
            // Filled; top-left corner: 250,10; Width/Height: 100,50; Rounded corners 30,50
            fillRoundRect(370.0, 10.0, 100.0, 50.0, 30.0, 50.0)

            // Demonstrating relationship between outline and line width:
            lineWidth = 15.0
            stroke = Color.rgb(0xFF, 0x14, 0x93, 0.5)
            // * Line is HALF inside, HALF outside of the rectangle
            fillRect(10.0, 130.0, 100.0, 50.0)
            strokeRect(10.0, 130.0, 100.0, 50.0)
            // * Line is completely INSIDE the rectangle
            fillRect(130.0, 130.0, 100.0, 50.0)
            strokeRect(130.0 + lineWidth / 2.0, 130.0 + lineWidth / 2.0, 100.0 - lineWidth, 50.0 - lineWidth)
            // * Line is completely OUTSIDE the rectangle
            fillRect(250.0, 130.0, 100.0, 50.0)
            strokeRect(250.0 - lineWidth / 2.0, 130.0 - lineWidth / 2.0, 100.0 + lineWidth, 50.0 + lineWidth)

            // Demonstrating how outline lines connect
            // * Round connection
            lineJoin = StrokeLineJoin.ROUND
            fillRect(10.0, 250.0, 100.0, 50.0)
            strokeRect(10.0, 250.0, 100.0, 50.0)
            // * Beveled connection
            lineJoin = StrokeLineJoin.BEVEL
            fillRect(130.0, 250.0, 100.0, 50.0)
            strokeRect(130.0, 250.0, 100.0, 50.0)
            // * Mitered connection
            lineJoin = StrokeLineJoin.MITER
            fillRect(250.0, 250.0, 100.0, 50.0)
            strokeRect(250.0, 250.0, 100.0, 50.0)
        }
        // ↑↑↑ Drawing using Canvas & graphicsContext2D ↑↑↑

        // ↓↓↓ Drawing using convenience class Rectangle ↓↓↓
        val myRectangles : MutableList<Shape> = mutableListOf(
            Rectangle(10.0, 10.0, 100.0, 50.0).apply {
                fill = Color.TRANSPARENT
                stroke = Color.BLACK
            },
            Rectangle(130.0, 10.0, 100.0, 50.0),
            Rectangle(250.0, 10.0, 100.0, 50.0).apply {
                arcHeight = 20.0
                arcWidth = 40.0
                fill = Color.TRANSPARENT
                stroke = Color.DEEPPINK
            },
            Rectangle(370.0, 10.0, 100.0, 50.0).apply {
                arcHeight = 50.0
                arcWidth = 30.0
                fill = Color.ORANGE
            },
            Rectangle(10.0, 130.0, 100.0, 50.0).apply {
                fill = Color.ORANGE
                stroke = Color.rgb(0xFF, 0x14, 0x93, 0.5) // Creating semi-transparent Color.DEEPPINK
                strokeWidth = 15.0
            },
            Rectangle(130.0, 130.0, 100.0, 50.0).apply {
                fill = Color.ORANGE
                stroke = Color.rgb(0xFF, 0x14, 0x93, 0.5)
                strokeWidth = 15.0
                strokeType = StrokeType.INSIDE                                   // Line is completely INSIDE the rectangle
            },
            Rectangle(250.0, 130.0, 100.0, 50.0).apply {
                fill = Color.ORANGE
                stroke = Color.rgb(0xFF, 0x14, 0x93, 0.5)
                strokeWidth = 15.0
                strokeType = StrokeType.OUTSIDE                                  // Line is completely OUTSIDE the rectangle
            },
            Rectangle(10.0, 250.0, 100.0, 50.0).apply {
                fill = Color.ORANGE
                stroke = Color.rgb(0xFF, 0x14, 0x93, 0.5)
                strokeWidth = 15.0
                strokeLineJoin = StrokeLineJoin.ROUND
            },
            Rectangle(130.0, 250.0, 100.0, 50.0).apply {
                fill = Color.ORANGE
                stroke = Color.rgb(0xFF, 0x14, 0x93, 0.5)
                strokeWidth = 15.0
                strokeLineJoin = StrokeLineJoin.BEVEL
            },
            Rectangle(250.0, 250.0, 100.0, 50.0).apply {
                fill = Color.ORANGE
                stroke = Color.rgb(0xFF, 0x14, 0x93, 0.5)
                strokeWidth = 15.0
                strokeLineJoin = StrokeLineJoin.MITER
            }
        )

        // Adding shapes created via union / subtraction of multiple rectangles. This is not possible with a Canvas:
        //   instead, one would have to use fillPolygon / strokePolygon.
        myRectangles.apply {
            add(
                Shape.union(
                Rectangle(10.0, 370.0, 100.0, 50.0),
                Rectangle(35.0, 370.0, 50.0, 100.0)).apply {
                    fill = Color.ORANGE
                    stroke = Color.rgb(0xFF, 0x14, 0x93, 0.5)
                    strokeWidth = 15.0
                    strokeLineJoin = StrokeLineJoin.MITER
                })
            add(
                Shape.subtract(Rectangle(130.0, 370.0, 100.0, 50.0),
                    Rectangle(150.0, 395.0, 60.0, 25.0)).apply {
                    fill = Color.ORANGE
                    stroke = Color.rgb(0xFF, 0x14, 0x93, 0.5)
                    strokeWidth = 15.0
                    strokeLineJoin = StrokeLineJoin.MITER
                })
        }
        // ↑↑↑ Drawing using convenience class Line ↑↑↑

        val content = myCanvas // comment in for using Canvas & graphicsContext2D
        //val content = myRectangles.toList() // comment in for using convenience class Line

        stage.apply {
            title = "Hello CS349! - JavaFX.Drawing.Rectangles"
            scene = Scene(Group(content), myCanvas.width, myCanvas.height).apply {
            }
        }.show()
    }
}
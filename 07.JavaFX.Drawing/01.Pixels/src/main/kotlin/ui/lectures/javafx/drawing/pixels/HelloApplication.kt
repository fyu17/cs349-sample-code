package ui.lectures.javafx.drawing.pixels

import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import javafx.stage.Stage
import kotlin.math.min
import kotlin.math.pow

class HelloPixels : Application() {
    override fun start(stage: Stage) {

        // Creating a canvas, and drawing its content by calling the function createMandelbrotImage(..).
        val myCanvas = Canvas(320.0, 240.0).apply {
            createMandelbrotImage(graphicsContext2D, width.toInt(), height.toInt())

            // Listening to changes in canvas size (width and height). Changes in size result in re-drawing the
            //   visualization of the Mendelbrot set. (This can become slow for larger screen sizes!)
            heightProperty().addListener { _ ->
                createMandelbrotImage(graphicsContext2D, width.toInt(), height.toInt())
            }
            widthProperty().addListener { _ ->
                createMandelbrotImage(graphicsContext2D, width.toInt(), height.toInt())
            }
        }

        stage.apply {
            title = "Hello CS349! - JavaFX.Drawing.Pixels"
            scene = Scene(Group(myCanvas), myCanvas.width, myCanvas.height).apply {
                // Binding canvas size (height and width) to the size of the scene. The result is that every change
                //   in window size automatically resizes the canvas as well, thus triggering the canvas'
                //   heightProperty / widthProperty.
                myCanvas.heightProperty().bind(heightProperty())
                myCanvas.widthProperty().bind(widthProperty())
            }
        }.show()
    }

    // ↓↓↓ This section is for drawing a visualization of a Mendelbrot set. ↓↓↓
    private fun createMandelbrotImage(gc: GraphicsContext, width: Int, height: Int) {
        (0 until width).forEach { x ->
            (0 until height).forEach { y ->
                val re = (x - width / 2.0) * 3.0 / min(width, height) - 0.75
                val im = (y - height / 2.0) * 3.0 / min(width, height)
                gc.pixelWriter.setColor(x, y, calculatePixelColor(re, im))
            }
        }
    }

    private val MAXITER = 16

    private fun calculatePixelColor(re: Double, im: Double): Color {
        var zx = 0.0
        var zy = 0.0
        var iter = -1
        var zxSqr = zx.pow(2)
        var zySqr = zy.pow(2)

        while ((zxSqr + zySqr < 8.0) and (iter < MAXITER)) {
            zy = 2.0 * zx * zy + im
            zx = zxSqr - zySqr + re
            zxSqr = zx.pow(2)
            zySqr = zy.pow(2)
            ++iter
        }
        return Color.hsb(360.0 * iter / MAXITER, 1.0, if (iter < MAXITER) 1.0 else 0.0)
    }
    // ↑↑↑ This section is for drawing a visualization of a Mendelbrot set. ↑↑↑
}
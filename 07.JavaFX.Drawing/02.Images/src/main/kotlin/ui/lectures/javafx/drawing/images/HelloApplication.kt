package ui.lectures.javafx.drawing.images

import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.stage.Stage

class HelloImages : Application() {
    override fun start(stage: Stage) {

        val plumberImage = Image("plumber.png", 176.0, 176.0, true, false)

        // ↓↓↓ Drawing using Canvas & graphicsContext2D ↓↓↓
        val myCanvas = Canvas(plumberImage.requestedWidth, plumberImage.requestedHeight)
        myCanvas.graphicsContext2D.apply {
            drawImage(plumberImage, 0.0, 0.0)
        }
        // ↑↑↑ Drawing using Canvas & graphicsContext2D ↑↑↑

        // ↓↓↓ Drawing using convenience class ImageView ↓↓↓
        val myImage = ImageView(plumberImage).apply {
            //isPreserveRatio = true
        }
        // ↑↑↑ Drawing using convenience class ImageView ↑↑↑

        val content = myCanvas // comment in for using Canvas & graphicsContext2D
        //val content = myImage // comment in for using convenience class ImageView

        stage.apply {
            title = "Hello CS349! - JavaFX.Drawing.Images"
            scene = Scene(Group(content), plumberImage.requestedWidth, plumberImage.requestedHeight).apply {
                // ↓↓↓ Drawing using convenience class ImageView ↓↓↓
                // Binding ImageView size (height and width) to the size of the scene. The result is that every change
                //   in window size automatically resizes the ImageView as well.
                myImage.fitHeightProperty().bind(heightProperty())
                myImage.fitWidthProperty().bind(widthProperty())
                // ↑↑↑ Drawing using convenience class ImageView ↑↑↑
            }
        }.show()
    }
}
import javafx.animation.AnimationTimer
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.StackPane
import javafx.stage.Stage

const val WIDTH = 800.0
const val HEIGHT = 300.0

class Main : Application() {

    override fun start(stage: Stage) {

        val canvas =  CanvasScene()
        val interpolation = Interpolation(50.0, WIDTH - 50.0, 1000)

        // create timer using JavaFX 60FPS execution thread
        val timer: AnimationTimer = object : AnimationTimer() {
            override fun handle(now: Long) {
                canvas.x = interpolation.update(now)
                canvas.draw()
            }
        }
        // start timer
        timer.start()

        // button to start the keyframe animation
        val button = Button("Start")
        button.setOnAction { interpolation.start() }
        button.translateY = 100.0

        val scene = Scene(StackPane(canvas, button), WIDTH, HEIGHT)
        stage.title = "Animation/Linear Interpolation"
        stage.isResizable = false
        stage.scene = scene
        stage.show()
    }
}

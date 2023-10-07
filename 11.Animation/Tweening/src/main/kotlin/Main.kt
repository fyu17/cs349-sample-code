import javafx.animation.AnimationTimer
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.StackPane
import javafx.stage.Stage
import kotlin.math.pow

const val WIDTH = 800.0
const val HEIGHT = 300.0

class Main : Application() {

    override fun start(stage: Stage) {

        val aniScene =
            when (1) {
                1 -> CanvasScene()
                2 -> ShapeScene()
                3 -> WidgetScene()
                else -> CanvasScene()
            }

        // easing functions
        val linear =  { x : Double -> x }
        val flip = { x: Double -> 1 - x }
        val easeIn = { x: Double -> x.pow(2) }
        val easeOut = { x: Double -> flip(easeIn(flip(x))) }
        val easeInOut = { x: Double -> lerp(easeIn(x), easeOut(x), x) }

        // create our keyframe calculation object
        val tween = Tween(50.0, WIDTH - 50.0, 1000, linear)

        // create timer using JavaFX 60FPS execution thread
        val timer: AnimationTimer = object : AnimationTimer() {
            override fun handle(now: Long) {
                tween.update(now)
                aniScene.x = tween.value
                aniScene.draw()
            }
        }
        // start timer
        timer.start()

        // button to start the keyframe animation
        val button = Button("Start")
        button.setOnAction { tween.start() }
        button.translateY = 100.0

        val scene = Scene(StackPane(aniScene, button), WIDTH, HEIGHT)
        stage.title = "Animation/Tweening"
        stage.isResizable = false
        stage.scene = scene
        stage.show()
    }
}

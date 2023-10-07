package ui.lectures.javafx.helloworld.helloworld

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.Pane
import javafx.stage.Stage

class HelloApplication : Application() {
    override fun start(primaryStage: Stage?) {
        val root = Pane()
        val scene = Scene(root, 320.00, 240.00)
        primaryStage?.scene = scene
        primaryStage?.title = "Hello CS349!"
        primaryStage?.isResizable = false
        primaryStage?.show()
    }

    //    override fun start(stage: Stage) {
//        stage.apply{
//            title = "Hello CS349!"
//            isResizable = false
//            scene = Scene(Pane(), 320.0, 240.0)
//        }.show()
//    }
}
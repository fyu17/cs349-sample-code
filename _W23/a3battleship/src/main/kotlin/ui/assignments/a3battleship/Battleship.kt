package ui.assignments.a3battleship

import ui.assignments.a3battleship.model.Game
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

class Battleship : Application() {
    override fun start(stage: Stage) {
        val game = Game(10, true)
        //val player = UI(game)
        val computer = AI(game)
        game.startGame()

        stage.apply {
            scene = Scene(null, 875.0, 375.0)
            title = "CS349 - A3 Battleship - watiam"
        }.show()
    }
}
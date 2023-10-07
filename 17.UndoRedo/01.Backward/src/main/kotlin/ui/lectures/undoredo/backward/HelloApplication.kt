package ui.lectures.undoredo.backward

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import ui.lectures.undoredo.backward.model.BalanceModel
import ui.lectures.undoredo.backward.view.BalanceView
import ui.lectures.undoredo.backward.viewmodel.BalanceViewModel

class HelloUndoRedo : Application() {
    override fun start(stage: Stage) {

        val myModel = BalanceModel()
        val myViewModel = BalanceViewModel(myModel)
        val counterView = BalanceView(myViewModel)

        stage.apply {
            title = "Hello CS349! - Undo / Redo"
            scene = Scene(counterView, 320.0, 240.0)
        }.show()
    }
}
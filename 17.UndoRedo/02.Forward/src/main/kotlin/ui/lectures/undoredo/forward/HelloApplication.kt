package ui.lectures.undoredo.forward

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import ui.lectures.undoredo.forward.model.Model
import ui.lectures.undoredo.forward.view.BalanceView
import ui.lectures.undoredo.forward.viewmodel.BalanceViewModel

class HelloUndoRedo : Application() {
    override fun start(stage: Stage) {

        val myModel = Model()
        val myViewModel = BalanceViewModel(myModel)
        val counterView = BalanceView(myViewModel)

        stage.apply {
            title = "Hello CS349! - Undo / Redo"
            scene = Scene(counterView, 320.0, 240.0)
        }.show()
    }
}
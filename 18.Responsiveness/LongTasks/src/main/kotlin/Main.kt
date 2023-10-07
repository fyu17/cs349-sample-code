import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Screen
import javafx.stage.Stage

enum class Demo { BLOCKING, SUBTASK, THREADING }

class Main : Application() {

   override fun start(stage: Stage) {
      val demoType = Demo.BLOCKING
      val num = 800_000

      val view =
         when (demoType) {
            // Blocking Demo (BAD)
            Demo.BLOCKING -> View(BlockingModel(1, num))
            // SubTasks Demo (BETTER)
            Demo.SUBTASK ->  View(SubtaskModel(1, num))
            // Thread Demo (BEST)
            Demo.THREADING -> View(ThreadModel(1, num))
      }

      val scene = Scene(view, 300.0, 300.0)
      stage.title = "LongTasks"
      stage.scene = scene
      stage.show()

      // for lecture demos
//      startOnScreen2(stage)
   }

   // for lecture demos
   // keeps application window on secondary display
   fun startOnScreen2(stage: Stage) {
      val w = Screen.getScreens()[1].getVisualBounds().maxX
      stage.x = w - stage.scene.width - 32.0
      stage.y = 64.0
   }
}

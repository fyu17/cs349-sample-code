import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.stage.Stage

class Main : Application() {
    override fun start(primaryStage: Stage?) {

        // create panels
        val leftPane = ListView<String>().apply {
            items.add("ABC")
            items.add("DEF")
            items.add("GHI")
            selectionModel.selectionMode = SelectionMode.SINGLE
            selectionModel.select(0);
        }

        val topPane = VBox().apply {
            prefHeight = 30.0
            background = Background(BackgroundFill(Color.valueOf("#00ffff"), null, null))
            setOnMouseClicked { println("top pane clicked") }

            children.addAll(
                MenuBar().apply {
                    menus.add(Menu("File"))
                    menus.add(Menu("Edit"))
                    menus.add(Menu("View"))
                },
                ToolBar().apply {
                    items.add(Button("Button 1"))
                    items.add(Button("Button 2"))
                    items.add(Button("Button 3"))
                })
        }

        val centrePane = Pane().apply {
            prefWidth = 100.0
            background = Background(BackgroundFill(Color.valueOf("#ffff00"), null, null))
            setOnMouseClicked { println("centre pane clicked") }            
        }

        // put the panels side-by-side in a container
        val root = BorderPane().apply {
            left = leftPane
            center = centrePane
            top = topPane
        }

        // create the scene and show the stage
        with (primaryStage!!) {
            scene = Scene(root, 600.0, 400.0)
            title = "A1 Sample"
            show()
        }
    }
}
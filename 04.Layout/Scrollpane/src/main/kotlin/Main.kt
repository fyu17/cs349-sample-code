import javafx.application.Application
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.scene.shape.Rectangle
import javafx.stage.Stage

// See the Oracle JavaFX scrollpane sample
// https://docs.oracle.com/javafx/2/ui_controls/scrollpane.htm

class Main : Application() {
    override fun start(stage: Stage) {

        // you can force the ScrollPane's use of scrollbars
//        root.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
//        root.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        val pane = Pane()
        pane.prefWidth = 600.0
        pane.prefHeight = 500.0
        pane.background = Background(BackgroundFill(Color.BLANCHEDALMOND, null, null))

        val circle = Circle(100.0, 150.0, 50.0)
        val rectangle = Rectangle(350.0, 250.0, 75.0, 75.0)
        pane.children.add(circle)
        pane.children.add(rectangle)

        circle.setOnMousePressed { event -> println("pressed circle"); event.consume() }
        circle.setOnMouseReleased { event -> println("released circle"); event.consume() }
        circle.setOnMouseDragged { event -> println("dragged circle"); event.consume() }

        rectangle.setOnMousePressed { event -> println("pressed rectangle"); event.consume() }
        rectangle.setOnMouseReleased { event -> println("released rectangle"); event.consume() }
        rectangle.setOnMouseDragged { event -> println("dragged rectangle"); event.consume() }

        pane.setOnMousePressed { println("pressed pane") }
        pane.setOnMouseReleased { println("released pane") }
        pane.setOnMouseDragged { println("dragged pane") }

        val scrollPane = ScrollPane()
        scrollPane.content = pane

        val items = ListView<String>()
        items.items.add("ABC")
        items.items.add("DEF")

        val root = BorderPane()
        root.left = items
        root. center = scrollPane

        stage.scene = Scene(root, 700.0, 400.0)
        stage.show()
    }
}
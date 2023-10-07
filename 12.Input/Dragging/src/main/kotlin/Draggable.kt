import javafx.event.EventHandler
import javafx.scene.Node

fun Node.makeDraggable() {

    // the offset captured at start of drag
    var offsetX = 0.0
    var offsetY = 0.0

    this.onMousePressed = EventHandler {
        println("down '$this'")
        offsetX = this.translateX - it.sceneX
        offsetY = this.translateY - it.sceneY
        // we don't want to drag the background too
        it.consume()
    }

    this.onMouseDragged = EventHandler {
        print("drag")
        this.translateX = it.sceneX + offsetX
        this.translateY = it.sceneY + offsetY
        // we don't want to drag the background too
        it.consume()
    }
}





import javafx.scene.canvas.Canvas
import javafx.scene.paint.Color
import javafx.scene.transform.Affine


class House() {
    val houseX = doubleArrayOf(30.0, 30.0, 0.0, -30.0, -30.0)
    val houseY = doubleArrayOf(30.0, -30.0, -60.0, -30.0, 30.0)
    var matrix = Affine().apply { setToIdentity() }

    fun draw(canvas: Canvas) {
        with(canvas.graphicsContext2D) {
            save()
            lineWidth = 5.0
            stroke = Color.BLACK
            fill = Color.MEDIUMPURPLE

            this.transform = matrix
            strokePolygon(houseX, houseY, 5)
            restore()
        }
    }

    val step = 10.0
    fun stepY(n:Int=1) = translateY(n*step)
    fun stepX(n:Int=1) = translateX(n*step)

    fun translateY(n:Double) {
        val original = matrix.clone()
        matrix.setToIdentity()
        matrix.appendTranslation(0.0, n)
        matrix.append(original)
    }
    fun translateX(n:Double) {
        val original = matrix.clone()
        matrix.setToIdentity()
        matrix.appendTranslation(n, 0.0)
        matrix.append(original)
    }

    val angle = 45.0
    fun rotate(n:Int=1) = matrix.appendRotation(n*angle)

    val scale = 2.0
    fun scaleUp(n:Int=1) = matrix.appendScale(n*scale, n*scale)
    fun scaleDown(n:Int=1) = matrix.appendScale(1/(n*scale), 1/(n*scale))
}

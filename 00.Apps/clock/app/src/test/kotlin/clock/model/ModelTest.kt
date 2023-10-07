package clock.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*


class ModelTest {
    @Test
    fun checkHour() {
        val model = Model()
        assertEquals(model.hour, Calendar.getInstance()[Calendar.HOUR_OF_DAY])
    }

    @Test
    fun checkMinutes() {
        val model = Model()
        assertEquals(model.minute, Calendar.getInstance()[Calendar.MINUTE])
    }

    @Test
    fun checkSeconds() {
        val model = Model()
        assertEquals(model.second, Calendar.getInstance()[Calendar.SECOND])
    }
}

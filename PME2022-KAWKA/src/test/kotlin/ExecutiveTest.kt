import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ExecutiveTest {

    @Test
    fun getExeGrade() {
        val executive1 = Executive("BO","Jean",1980, Grade.A)
        var expected = Grade.A
        assertEquals(expected, executive1.getExeGrade())

        val executive2 = Executive("BO","Jean",1980, Grade.B)
        var expected2 = Grade.B
        assertEquals(expected2, executive2.getExeGrade())

        val executive3 = Executive("BO","Jean",1980, Grade.B)
        var expected3 = Grade.C
        assertNotEquals(expected3, executive3.getExeGrade())
    }

    @Test
    fun changeGrade() {
        val executive1 = Executive("BO","Jean",1980, Grade.A)
        executive1.changeGrade(Grade.B)
        var expected = Grade.B
        assertEquals(expected, executive1.getExeGrade())

        val executive2 = Executive("BO","Jean",1980, Grade.B)
        var expected2 = Grade.B
        assertEquals(expected2, executive2.getExeGrade())
        executive2.changeGrade(Grade.A)
        assertNotEquals(expected2, executive2.getExeGrade())

        val executive3 = Executive("BO","Jean",1980, Grade.B)
        executive3.changeGrade(Grade.A)
        val notexpected = Grade.B
        assertNotEquals(notexpected, executive3.getExeGrade())
    }
}
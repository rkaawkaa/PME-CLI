import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PersonTest {

    @Test
    fun getfirstName() {
        val employee1 = Employee("LEGRAND","Alexandre",1990)
        var expected = "LEGRAND"
        assertEquals(expected, employee1.getlastName())
        val employee2 = Employee("CHA","Romulus",1990)
        var expected2 = "CHA"
        assertEquals(expected2, employee2.getlastName())
    }

    @Test
    fun getlastName() {
        val employee1 = Employee("LEGRAND","Alexandre",1990)
        var expected = "Alexandre"
        assertEquals(expected, employee1.getfirstName())
        val employee2 = Employee("LEGRAND","Romulus",1990)
        var expected2 = "Romulus"
        assertEquals(expected2, employee2.getfirstName())
        val employee3 = Employee("LEGRAND","Bob",1990)
        var notexpected3 = "Boby"
        assertNotEquals(notexpected3, employee3.getfirstName())
    }

    @Test
    fun setfirstName() {
        val employee1 = Employee("LEGRAND","Alexandre",1990)
        employee1.setfirstName("Bob")
        var expected = "Bob"
        assertEquals(expected, employee1.getfirstName())

        val employee2 = Employee("LEGRAND","Alexandre",1990)
        employee2.setfirstName("Alice")
        var notexpected="Alexandre"
        assertNotEquals(notexpected, employee2.getfirstName())
    }

    @Test
    fun setlastName() {
        val employee1 = Employee("LEGRAND","Alexandre",1990)
        employee1.setlastName("CHAGNON")
        var expected = "CHAGNON"
        assertEquals(expected, employee1.getlastName())
    }


}
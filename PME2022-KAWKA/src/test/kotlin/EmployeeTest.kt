import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class EmployeeTest {


    @Test
    fun getEmpSalary() {
        val employee1 = Employee("LEGRAND","Alexandre",1990)
        var notexpected = 1600;
        assertNotEquals(notexpected, employee1.getEmpSalary())

        val employee2 = Employee("LEGRAND","Alexandre",2000)
        var expected = 2200;
        assertEquals(expected, employee2.getEmpSalary())

        val employee3 = Employee("LEGRAND","Alexandre", 2018)
        var expected2 = 0;
        assertEquals(expected2, employee3.getEmpSalary())

    }

    @Test
    fun getEmpSalaryExecutive() {
        val cadre1 = Executive("LEGRAND","Alexandre",2000, Grade.A)
        var expected1 = 2500
        assertEquals(expected1, cadre1.getEmpSalary())

        val cadre2 = Executive("JOUT","Johanna", 1990, Grade.C)
        var expected2 = 3300
        assertEquals(expected2, cadre2.getEmpSalary())

        val cadre3 = Executive("JOUT","Benoit", 1995, Grade.C)
        var expected3 = 3300
        assertNotEquals(expected3, cadre3.getEmpSalary())
    }

}
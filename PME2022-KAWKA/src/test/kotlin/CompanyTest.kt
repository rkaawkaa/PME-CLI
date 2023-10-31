import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CompanyTest {

    @Test
    fun modifyName() {
        var company1 = Company("Gleeph", 2000.5)
        company1.modifyName("F451")
        var expected = "F451"
        assertEquals(expected, company1.getCompName())

        company1.modifyName("LVMH")
        var notexpected = "F451"
        assertNotEquals(notexpected, company1.getCompName())


        company1.modifyName("Adidas")
        expected = "Adidas"
        assertEquals(expected, company1.getCompName())
    }

    @Test
    fun modifyTurnOver() {
        var company1 = Company("Gleeph", 2000.5)
        var expected = 2000.5
        assertEquals(expected, company1.getTurnOver())


        company1.modifyTurnOver(21000.0)
        expected = 21000.0
        assertEquals(expected, company1.getTurnOver())

        company1.modifyTurnOver(23000.0)
        var notexpected = 21000.0
        assertNotEquals(notexpected, company1.getTurnOver())

    }
}
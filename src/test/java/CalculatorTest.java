import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAddition2Numbers_RunSuccess() {
        // Arrange
        Calculator calculator = new Calculator();
        // Act
        int res = calculator.add(1,2);
        // Assert
        assertEquals(3,res);
    }

    @Test
    void TestDivideByZero_ResultsArithmeticException() {
        Calculator calculator = new Calculator();

        assertThrows(ArithmeticException.class, ()->calculator.divide(1,0));

    }
}
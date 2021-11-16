import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests {
 Calculator calculator;
    @BeforeEach
    void setUp() {

        calculator = new Calculator();
    }
    @Test
    void method_calculate_01_03_should_return_99_precntage(){
        assertEquals(99.7503124074893,calculator.calcuate_01_03(0.000001,2500));
    }
    @Test
    void method_calculate_01_04_should_return_0_04() {
        assertEquals(4.040541463503893E-6,calculator.calculate_01_04(0.98,  5000));
    }
    @Test
    void method_calculate_01_05_should_return_two_given_values() {
        double[] expected = new double[] {0.04,0.30119445503122655};
        assertArrayEquals(expected,calculator.calculate_01_05(25, 30));
    }

    @Test
    void method_calculate_01_06_should_return_0_30() {
    assertEquals(0.6065308637049162,calculator.calculate_01_06(1000, 500));
    }


    @Test
    void method_calculate_03_01_should_return_two_given_values() {
       // assertEquals(0.6065308637049162,calculator.calculate_03_01(3,26,200, 257));
    }


}

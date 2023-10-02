import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Calculation_classTest {

    @Test

    void TestgetTailorMethod_x_negative() {
        Calculation_class obj2 = new Calculation_class(-0.3, 3);
        double expectedTailor = 1.0/Math.sqrt(1-0.3);
        double actualTailor = obj2.getTailor();
        assertEquals(expectedTailor, actualTailor, 0.0001);
    }

    @Test
    void TestgetTailorMethod_x_positive() {
        Calculation_class obj2 = new Calculation_class(0.7, 3);
        double expectedTailor = 1.0/Math.sqrt(1+0.7);
        double actualTailor = obj2.getTailor();
        assertEquals(expectedTailor, actualTailor, 0.0001);
    }

    @Test
    void TestgetTailorMethod_x_close_to_negative_one() {
        Calculation_class obj2 = new Calculation_class(-0.99, 3);
        double expectedTailor = 1.0/Math.sqrt(1-0.99);
        double actualTailor = obj2.getTailor();
        assertEquals(expectedTailor, actualTailor, 0.001);
    }

    @Test
    void TestgetTailorMethod_x_close_to_positive_one() {
        Calculation_class obj2 = new Calculation_class(0.99, 3);
        double expectedTailor = 1.0/Math.sqrt(1+0.99);
        double actualTailor = obj2.getTailor();
        assertEquals(expectedTailor, actualTailor, 0.0001);
    }
}
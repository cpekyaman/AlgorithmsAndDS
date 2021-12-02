package grokalg.ch03;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FactorialTest extends Assertions {

    private Factorial factorial;

    @BeforeEach
    void setUp() {
        factorial = new Factorial();
    }

    @Test
    void negativeInputShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> factorial.calculate(-1));
    }

    @Test
    void testZeroFactorial() {
        assertThat(factorial.calculate(0)).isEqualTo(1);
    }

    @Test
    void testFactorial() {
        assertThat(factorial.calculate(5)).isEqualTo(120);
        assertThat(factorial.calculate(4)).isEqualTo(24);
    }
}
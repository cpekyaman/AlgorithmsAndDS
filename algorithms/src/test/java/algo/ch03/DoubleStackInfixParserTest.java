package algo.ch03;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class DoubleStackInfixParserTest extends Assertions {
    private DoubleStackInfixParser parser;

    @BeforeEach
    void setUp() {
        parser = new DoubleStackInfixParser();
    }

    @Test
    void shouldBeAbleToParseSimpleExpression() {
        assertThat(parser.parse("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )")).isEqualTo(101);
        assertThat(parser.parse("( 2 + ( ( 5 - 3 ) * ( 8 / 2 ) ) )")).isEqualTo(10);
    }
}
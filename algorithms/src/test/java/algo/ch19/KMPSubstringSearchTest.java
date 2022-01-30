package algo.ch19;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class KMPSubstringSearchTest extends Assertions {
    @ParameterizedTest
    @CsvSource({"abacadabrac,abra,6", "daedalus,dal,3", "primary,man,-1", "aaabacbra,aab,1"})
    void shouldSearchThePatternInString(String text, String pattern, int expected) {
        assertThat(new KMPSubstringSearch(pattern).findInText(text)).isEqualTo(expected);
    }
}
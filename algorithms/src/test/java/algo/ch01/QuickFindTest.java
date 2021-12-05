package algo.ch01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class QuickFindTest extends Assertions {

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 6, 8, 9})
    void shouldHaveNoConnectionsInitially(int objectCount) {
        // when
        QuickFind qf = new QuickFind(objectCount);

        // then
        for (int i = 0; i < objectCount; i++) {
            for (int j = 0; j < objectCount; j++) {
                if(i == j) {
                    continue;
                }

                assertThat(qf.isConnected(i, j)).isFalse();
            }
        }
    }

    @Test
    void shouldBeAbleToConnectDataPoints() {
        // given
        QuickFind qf = new QuickFind(10);

        // when
        qf.union(3, 6);
        // then
        assertThat(qf.isConnected(3, 6)).isTrue();
        assertThat(qf.isConnected(5, 2)).isFalse();

        // and
        qf.union(5, 2);
        // then
        assertThat(qf.isConnected(5, 2)).isTrue();
        assertThat(qf.isConnected(3, 5)).isFalse();

        // and
        qf.union(6, 2);
        // then
        assertThat(qf.isConnected(3, 5)).isTrue();
    }
}
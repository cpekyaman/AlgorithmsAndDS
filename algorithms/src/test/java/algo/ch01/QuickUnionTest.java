package algo.ch01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class QuickUnionTest extends Assertions {

    @ParameterizedTest
    @ValueSource(ints = {5, 7, 4, 9})
    void shouldHaveNoConnectionsInitially(int objectCount) {
        // when
        QuickUnion qu = new QuickUnion(objectCount);

        // then
        for (int i = 0; i < objectCount; i++) {
            for (int j = 0; j < objectCount; j++) {
                if(i == j) {
                    continue;
                }
                assertThat(qu.isConnected(i, j)).isFalse();
            }
        }
    }

    @Test
    void shouldBeAbleToConnectDataPoints() {
        // given
        QuickUnion qu = new QuickUnion(10);

        // when
        qu.union(2, 7);
        // then
        assertThat(qu.isConnected(2, 7)).isTrue();
        assertThat(qu.isConnected(4, 8)).isFalse();

        // and
        qu.union(4, 8);
        // then
        assertThat(qu.isConnected(4, 8)).isTrue();
        assertThat(qu.isConnected(7, 8)).isFalse();

        // and
        qu.union(2, 4);
        // then
        assertThat(qu.isConnected(7, 8)).isTrue();
    }
}
package grokalg.ch08;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;


class GreedyAlgTest extends Assertions {

    private GreedyAlg algorithm;

    @BeforeEach
    void setUp() {
        algorithm = new GreedyAlg();
    }

    @Test
    void shouldFindOptimalSet() {
        // given
        Set<String> statesToCover = Set.of("mt", "wa", "or", "id", "nv", "ut", "ca", "az");

        // when
        Set<String> stationsToUse = algorithm.findStationsToUse(statesToCover);

        //then
        Set<String> coveredStates = algorithm.findCoveredStates(stationsToUse);
        assertThat(coveredStates.containsAll(statesToCover)).isTrue();
        assertThat(coveredStates).hasSameSizeAs(statesToCover);
    }
}
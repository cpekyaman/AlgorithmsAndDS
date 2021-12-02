package grokalg.ch08;

import java.util.*;
import java.util.stream.Collectors;

public final class GreedyAlg {
    private final Map<String, Set<String>> stationCoverages;

    public GreedyAlg() {
        this.stationCoverages = new HashMap<>();
        fillCoverageMap();
    }

    private void fillCoverageMap() {
        stationCoverages.put("kone", Set.of("id", "nv", "ut"));
        stationCoverages.put("ktwo", Set.of("wa", "id", "mt"));
        stationCoverages.put("kthree", Set.of("or", "nv", "ca"));
        stationCoverages.put("kfour", Set.of("nv", "ut"));
        stationCoverages.put("kfive", Set.of("ca", "az"));
    }

    public Set<String> findCoveredStates(Set<String> stations) {
        return stationCoverages.entrySet()
                               .stream()
                               .filter(e -> stations.contains(e.getKey()))
                               .flatMap(e -> e.getValue().stream())
                               .collect(Collectors.toSet());
    }

    public Set<String> findStationsToUse(Set<String> statesToCover) {
        Set<String> statesNotCovered = new HashSet<>(statesToCover);
        Set<String> stationsUsed = new HashSet<>();

        while(! statesNotCovered.isEmpty()) {
            String bestStation = null;
            Set<String> bestCoverage = Collections.emptySet();

            for (Map.Entry<String, Set<String>> station : stationCoverages.entrySet()) {
                Set<String> currentCoverage = new HashSet<>(statesNotCovered);
                currentCoverage.retainAll(station.getValue());
                if(currentCoverage.size() > bestCoverage.size()) {
                    bestCoverage = currentCoverage;
                    bestStation = station.getKey();
                }
            }

            statesNotCovered.removeAll(bestCoverage);
            stationsUsed.add(bestStation);
        }

        return stationsUsed;
    }
}

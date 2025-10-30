// https://leetcode.com/problems/cheapest-flights-within-k-stops/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;
import java.util.*;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // Build adjacency list: city -> List of (neighbor, price)
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], x -> new ArrayList<>()).add(new int[] {flight[1], flight[2]});
        }

        // PriorityQueue sorts entries by price
        // Each entry: {priceSoFar, currentCity, stopsUsed}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] {0, src, 0});

        // Best prices to a city with <= stops used to prevent useless expansions
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);
        best[src] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int price = cur[0], city = cur[1], stops = cur[2];

            if (city == dst) return price;
            if (stops > K) continue;

            List<int[]> neighbors = graph.getOrDefault(city, Collections.emptyList());
            for (int[] next : neighbors) {
                int nextCity = next[0];
                int nextPrice = next[1];
                int newPrice = price + nextPrice;

                if (newPrice < best[nextCity] && stops <= K) {
                    best[nextCity] = newPrice;
                    pq.offer(new int[] {newPrice, nextCity, stops + 1});
                }
            }
        }
        return -1;
    }

    // Example run in Eclipse IDE
    public static void main(String[] args) {
        CheapestFlightsWithinKStops solution = new CheapestFlightsWithinKStops();
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0;
        int dst = 3;
        int K = 1;
        System.out.println("Cheapest Price: " + solution.findCheapestPrice(n, flights, src, dst, K)); // Expected: 700
    }
}

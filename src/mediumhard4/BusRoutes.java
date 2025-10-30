// https://leetcode.com/problems/bus-routes/description/?envType=problem-list-v2&envId=rabvlt31

package mediumhard4;

import java.util.*;

public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        // Map bus stop to list of bus routes (buses) that go through it
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToBuses.computeIfAbsent(stop, x -> new ArrayList<>()).add(i);
            }
        }

        // BFS queue stores buses taken, starting from all buses that have the source stop
        Queue<Integer> queue = new LinkedList<>();
        // To keep track of visited bus routes to avoid repeats
        boolean[] visitedBuses = new boolean[routes.length];
        // To keep track of visited stops for pruning
        Set<Integer> visitedStops = new HashSet<>();
        
        // Add all buses passing through source stop to queue
        for (int bus : stopToBuses.getOrDefault(source, new ArrayList<>())) {
            queue.offer(bus);
            visitedBuses[bus] = true;
        }
        visitedStops.add(source);

        int busesTaken = 1; // We start by taking first bus

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int bus = queue.poll();
                // If this bus route contains the target stop, return current buses taken
                for (int stop : routes[bus]) {
                    if (stop == target) {
                        return busesTaken;
                    }
                    if (!visitedStops.contains(stop)) {
                        visitedStops.add(stop);
                        // Add all buses going through this stop next
                        for (int nextBus : stopToBuses.getOrDefault(stop, new ArrayList<>())) {
                            if (!visitedBuses[nextBus]) {
                                visitedBuses[nextBus] = true;
                                queue.offer(nextBus);
                            }
                        }
                    }
                }
            }
            busesTaken++;
        }
        return -1; // No route found
    }

    // Example to run in Eclipse IDE
    public static void main(String[] args) {
        BusRoutes solution = new BusRoutes();

        int[][] routes = {{1, 2, 7}, {3, 6, 7}};
        int source = 1;
        int target = 6;

        int result = solution.numBusesToDestination(routes, source, target);
        System.out.println("Minimum buses to destination: " + result);  // Expected: 2
    }
}

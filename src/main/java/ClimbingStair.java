import java.util.HashMap;
import java.util.Map;

public class ClimbingStair {
    public void run() {
        int[] cost = new int[]{20, 15, 30, 5, 7, 2, 8, 2, 5, 8, 2, 4, 7, 22, 464, 23, 23, 254, 74};
        // end point -1 / -2

        Map<Integer, Integer> costMap = new HashMap<>();
        System.out.println(minCost(costMap, cost, cost.length - 1));
    }

    public int minCost(Map<Integer, Integer> costMap, int[] cost, int indexA) {
        if (indexA <= 0) {
            return cost[indexA];
        }

        if (indexA == 1) {
            return cost[indexA];
        }
        //    return  cost[indexA] +  Math.min( minCost(costMap,cost,indexA-1), minCost(costMap,cost,indexA-2));
        if (!costMap.containsKey(indexA)) {
            costMap.put(indexA, cost[indexA] + Math.min(minCost(costMap, cost, indexA - 1), minCost(costMap, cost, indexA - 2)));
            return cost[indexA] + Math.min(minCost(costMap, cost, indexA - 1), minCost(costMap, cost, indexA - 2));
        } else {
            return costMap.get(indexA);
        }

    }
}

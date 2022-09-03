import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
    public void run() {
        int[] houses = new int[]{8, 4, 8, 5, 9, 6, 5, 4, 4, 10};
        // start from end : top-down
        HashMap<Integer, Integer> dp = new HashMap<>();
        int result = rob(houses, houses.length - 1, dp);
        System.out.println(result);
    }

    public int rob(int[] houses, int index, HashMap<Integer, Integer> dp) {
        // base case
        if (index < 0) {
            return 0;
        }
        if (dp.containsKey(index)) {
            return dp.get(index);
        }
        return Math.max(rob(houses, index - 2, dp) + houses[index], rob(houses, index - 1, dp));
    }
}

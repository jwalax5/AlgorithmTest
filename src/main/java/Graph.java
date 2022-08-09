import java.util.*;
import java.util.stream.IntStream;

public class Graph {
    public void run() {
        List<int[]> adjacentList = new ArrayList<>();
        int[] nodeA = IntStream.of(1, 3).toArray();
        int[] nodeB = IntStream.of(0).toArray();
        int[] nodeC = IntStream.of(3, 8).toArray();
        int[] nodeD = IntStream.of(0, 4, 5, 2).toArray();
        int[] nodeE = IntStream.of(3, 6).toArray();
        int[] nodeF = IntStream.of(3).toArray();
        int[] nodeG = IntStream.of(4, 7).toArray();
        int[] nodeH = IntStream.of(6).toArray();
        int[] nodeI = IntStream.of(2).toArray();
        adjacentList.add(nodeA);
        adjacentList.add(nodeB);
        adjacentList.add(nodeC);
        adjacentList.add(nodeD);
        adjacentList.add(nodeE);
        adjacentList.add(nodeF);
        adjacentList.add(nodeG);
        adjacentList.add(nodeH);
        adjacentList.add(nodeI);

        List<Integer> resultList = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();
        dfs(0, adjacentList, resultList, seen);
        System.out.println("DFS : " + resultList);
        List<Integer> resultBFSList = new ArrayList<>();
        bfs(adjacentList, resultBFSList);

        System.out.println("BFS : " + resultBFSList);
    }

    public void dfs(int currentNodeIndex, List<int[]> adjacentList, List<Integer> result, HashSet<Integer> seen) {
        // base case
        int[] neibour = adjacentList.get(currentNodeIndex);
        if (neibour.length == 0) return;
        result.add(currentNodeIndex);
        seen.add(currentNodeIndex);
        // child
        for (int nodeInx : neibour) {
            if (!seen.contains(nodeInx)) {
                dfs(nodeInx, adjacentList, result, seen);
            }
        }
    }

    public void bfs(List<int[]> adjacentList, List<Integer> result) {
        if (adjacentList.size() == 0) return;
        HashSet<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int currentNodeIndex = queue.poll();
            result.add(currentNodeIndex);
            seen.add(currentNodeIndex);
            int[] neibour = adjacentList.get(currentNodeIndex);
            for (int nodeInx : neibour) {
                if (!seen.contains(nodeInx)) {
                    queue.add(nodeInx);
                }
            }
        }
    }
}

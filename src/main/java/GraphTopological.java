import java.util.*;
import java.util.stream.IntStream;

public class GraphTopological {
    public void run() {
        List<int[]> prerequisites = new ArrayList<>();
        int[] directLinkageA = IntStream.of(1, 0).toArray();
        int[] directLinkageB = IntStream.of(2, 1).toArray();
        int[] directLinkageC = IntStream.of(2, 5).toArray();
        int[] directLinkageD = IntStream.of(0, 3).toArray();
        int[] directLinkageE = IntStream.of(4, 3).toArray();
        int[] directLinkageF = IntStream.of(3, 5).toArray();
        int[] directLinkageG = IntStream.of(4, 5).toArray();
      //  int[] directLinkageMakeCycle = IntStream.of(4, 2).toArray();
        prerequisites.add(directLinkageA);
        prerequisites.add(directLinkageB);
        prerequisites.add(directLinkageC);
        prerequisites.add(directLinkageD);
        prerequisites.add(directLinkageE);
        prerequisites.add(directLinkageF);
        prerequisites.add(directLinkageG);
    //    prerequisites.add(directLinkageMakeCycle);
        Map<Integer, Integer> inDegree = new HashMap<>();
        inDegree.put(0, 0);
        inDegree.put(1, 0);
        inDegree.put(2, 0);
        inDegree.put(3, 0);
        inDegree.put(4, 0);
        inDegree.put(5, 0);
        for (int[] prerequisite : prerequisites) {
            inDegree.merge(prerequisite[0], 1, Integer::sum);
        }

        List<int[]> adjacentList = new ArrayList<>();
        int[] nodeA = IntStream.of(1).toArray();
        int[] nodeB = IntStream.of(2).toArray();
        int[] nodeC = IntStream.of().toArray();
        int[] nodeD = IntStream.of(0, 4).toArray();
        int[] nodeE = IntStream.of().toArray();
        int[] nodeF = IntStream.of(2, 3, 4).toArray();
        adjacentList.add(nodeA);
        adjacentList.add(nodeB);
        adjacentList.add(nodeC);
        adjacentList.add(nodeD);
        adjacentList.add(nodeE);
        adjacentList.add(nodeF);
        boolean result = topological(inDegree, adjacentList);
        System.out.println("result : " + result);

    }

    public boolean topological(Map<Integer, Integer> inDegree, List<int[]> adjacentList) {
        // find which inDegree is 0, remove it , if indegree's adj list contain this inDegree , minus 1
        Iterator<Map.Entry<Integer, Integer>> it = inDegree.entrySet().iterator();
        Stack<Integer> noInDegreeStack = new Stack<>();

        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                noInDegreeStack.add(entry.getKey());
            }
        }
        int count = 0;
        while (!noInDegreeStack.isEmpty()) {
            Integer noInDegreeKey = noInDegreeStack.pop();
            count++;
            int[] adjNodes = adjacentList.get(noInDegreeKey);
            for (int i : adjNodes) {
                inDegree.merge(i, -1, Integer::sum);
                if (inDegree.get(i) == 0) {
                    noInDegreeStack.add(i);
                }
            }
        }
        System.out.println("inDegree : " + inDegree.size());
        System.out.println("count : " + count);
        return inDegree.size() == count;

    }
}

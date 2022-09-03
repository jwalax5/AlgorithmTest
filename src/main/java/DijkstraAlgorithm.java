import java.util.*;

// not support negative weight - if there is negative weight, use Bellman-Ford
// bellman -Ford dynamic programming, loop n-1 times, keep updating the distance list until no change
//can detect negative cycle (value keep update even > n-1 loop)
public class DijkstraAlgorithm {
    public void run() {
        // assumption : no negative weight
        int k = 1; // start node
        List<int[]> times = new ArrayList<>();
        // source , dest , time need
        times.add(new int[]{1,2,9});
        times.add(new int[]{1,4,2});
        times.add(new int[]{2,5,1});
        times.add(new int[]{4,2,4});
        times.add(new int[]{4,5,6});
        times.add(new int[]{3,2,3});
        times.add(new int[]{5,3,7});
        times.add(new int[]{3,1,5});

        // need distance list to monitor current time taken
        int[] distances = new int[times.size()];
        distances[k-1] = 0; // start node distance = 0
        // need adjacent list of time taken to all other node for each starting node - set infinity as default
        // adj list: [ dest, time(infinity as default)]
        Map<int[],Integer> adjList = new HashMap<>();
        for(int[] time: times){
            adjList.put(new int[]{time[0],time[1]},time[2]);
        }
        for (Map.Entry<int[],Integer> a:
        adjList.entrySet()) {
            System.out.println(a.getKey()[0] + " -- " + a.getKey()[1]  + " -- " +  a.getValue());
        }
        // min heap for storing min time of next distances
        Queue<Integer> minHeap = new PriorityQueue<>(); // default is min heap

    }
    public int findShortestPath(String input) {
        return 0;
    }
}

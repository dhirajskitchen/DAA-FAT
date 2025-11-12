import java.util.*;

public class travellingSalesperson {
    static int ans = Integer.MAX_VALUE;
    static int[][] graph;
    static boolean visited[];
    static List<Integer> bestPath;

    static public void TSP(List<Integer> l, int count, int n, int curr, int city, int start) {
        if (count == n - 1) {
            curr += graph[city][start];
            ans = Math.min(ans, curr);
            if (ans == curr)
                bestPath = new ArrayList<>(l);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && graph[city][i] != 0) {
                visited[i] = true;
                l.add(i);
                TSP(l, count + 1, n, curr + graph[city][i], i, start);
                l.remove(l.size() - 1);
                visited[i] = false;
            }
        }
    }

    static public void main(String args[]) {
        graph = new int[][] {
                { 0, 10, 15, 20 },
                { 10, 0, 35, 25 },
                { 15, 35, 0, 30 },
                { 20, 25, 30, 0 }
        };
        visited = new boolean[graph.length];
        visited[0] = true;
        TSP(new ArrayList<>(), 0, graph.length, 0, 0, 0);
        System.out.print(bestPath + "\n");
        System.out.println(ans);
    }
}

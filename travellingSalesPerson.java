import java.util.*;

class travellingSalesPerson {
    static int cost[][];
    static int n;
    static int visited[];
    static int ans = Integer.MAX_VALUE;

    static public List<Integer> TSP(int count, int n, List<Integer> set, int curr, int start, int city) {
        if (count == n) {
            ans = Math.min(ans, curr + cost[city][start]);
            return set;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != 1 && cost[city][i] != 0) {
                visited[i] = 1;
                set.add(i);
                TSP(count, n, set, curr + cost[city][i], start, i);
                set.remove(set.size() - 1);
                visited[i] = 0;
            }
        }
        return set;
    }

    public static void main(String[] args) {
        cost = new int[][] {
                { 0, 10, 15, 20 },
                { 10, 0, 35, 25 },
                { 15, 35, 0, 30 },
                { 20, 25, 30, 0 }
        };

        n = cost.length;
        visited = new int[n];

        visited[0] = 1;
        TSP(0, n, new ArrayList<>(), 0, 0, 0);

        System.out.println("Minimum Cost = " + ans);
    }
}
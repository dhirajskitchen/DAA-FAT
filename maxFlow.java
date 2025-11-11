import java.util.LinkedList;
import java.util.Queue;

public class maxFlow {
    static public boolean bfs(int[][] capacity, int[][] flow, int s, int t, int parent[]) {
        int n = capacity.length;
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        parent[s] = -1;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < n; v++) {
                if (!visited[v] && capacity[u][v] - flow[u][v] > 0) {
                    q.add(v);
                    visited[v] = true;
                    parent[v] = u;
                }
            }
        }
        return visited[t];
    }

    static public int MF(int[][] capacity,int s,int t){
        int n=capacity.length;
        int flow[][]=new int[n][n];
        int parent[]=new int[n];
        int maxFlow=0;
        while (bfs(capacity,flow,s,t,parent)) {
            int pathFlow=Integer.MAX_VALUE;
            for(int v=t;v!=s;v=parent[v]){
                int u=parent[v];
                pathFlow=Math.min(pathFlow,capacity[u][v]-flow[u][v]);
            }
            for(int v=t;v!=s;v=parent[v]){
                int u=parent[v];
                flow[u][v]+=pathFlow;
                flow[v][u]-=pathFlow;
            }
            maxFlow+=pathFlow;
        }
        return maxFlow;
    }

    public static void main(String[] args) {

        // Example capacity graph represented as matrix
        // capacity[u][v] = max capacity of edge u->v
        int[][] capacity = {
                { 0, 8, 0, 0, 3, 0 },
                { 0, 0, 9, 0, 0, 0 },
                { 0, 0, 0, 7, 0, 2 },
                { 0, 0, 0, 0, 0, 5 },
                { 0, 0, 7, 4, 0, 0 },
                { 0, 0, 0, 0, 0, 0 }
        };

        int source = 0; // Starting node
        int sink = 5; // Destination node

        System.out.println("Maximum Flow = " + MF(capacity, source, sink));
    }
}

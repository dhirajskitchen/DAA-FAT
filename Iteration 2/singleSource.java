class Edge {
    int s, d, w;

    Edge(int S, int D, int W) {
        s = S;
        d = D;
        w = W;
    }
}

public class singleSource {
    static int e = 8, v = 5;

    static Edge[] edges = new Edge[e];
    static int[] distance = new int[v];
    static int inf = 999;
    static {
        edges[0] = new Edge(0, 1, -1);
        edges[1] = new Edge(0, 2, 4);
        edges[2] = new Edge(1, 2, 3);
        edges[3] = new Edge(1, 3, 2);
        edges[4] = new Edge(1, 4, 2);
        edges[5] = new Edge(3, 2, 5);
        edges[6] = new Edge(3, 1, 1);
        edges[7] = new Edge(4, 3, -3);

        for (int i = 0; i < v; i++)
            distance[i] = inf;
        distance[0] = 0;
    }

    static public void SS() {
        for (int i = 1; i < v; i++) {
            for (Edge e : edges) {
                if (distance[e.s] + e.w < distance[e.d]) {
                    distance[e.d] = distance[e.s] + e.w;
                }
            }
        }
        return;
    }

    static public void main(String args[]) {
        SS();
        for (int i = 0; i < v; i++)
            System.out.printf("%d ", distance[i]);
    }
}

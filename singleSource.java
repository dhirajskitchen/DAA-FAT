class singleSource {
    static public int[] BF(int cost[][]) {
        int dist[] = new int[cost.length];
        for (int i = 1; i < dist.length; i++)
            dist[i] = Integer.MAX_VALUE;
        int n = cost.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i] != Integer.MAX_VALUE && cost[i][j] != Integer.MAX_VALUE && dist[i] + cost[i][j] < dist[j]) {
                    dist[j] = dist[i] + cost[i][j];
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int inf = Integer.MAX_VALUE;
        int[][] cost = {
                { 0, 4, inf, 5 },
                { inf, 0, 3, inf },
                { inf, inf, 0, 1 },
                { inf, inf, inf, 0 }
        };

        int dist[] = BF(cost);
        for (int i = 0; i < dist.length; i++)
            System.out.print(dist[i] + " ");
    }
}
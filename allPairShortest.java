public class allPairShortest {
    static public void FW(int cost[][]) {
        int n = cost.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (cost[i][k] + cost[k][j] < cost[i][j]) {
                        cost[i][j] = cost[i][k] + cost[k][j];
                    }
                }
            }
        }
    }

    static public void main(String args[]) {
        int inf = 999;
        int[][] cost = {
                { 0, 4, inf, 5 },
                { inf, 0, 3, inf },
                { inf, inf, 0, 1 },
                { inf, inf, inf, 0 }
        };
        FW(cost);
        int n = cost.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(cost[i][j] + " ");
            }
            System.out.println();
        }
    }
}

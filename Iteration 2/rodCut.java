public class rodCut {
    static public int RC(int prices[]) {
        int n = prices.length;
        int dp[] = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], prices[j - 1] + dp[i - j]);
            }
        }
        return dp[n];
    }

    static public void main(String args[]) {
        int prices[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        System.out.print(RC(prices));
    }
}

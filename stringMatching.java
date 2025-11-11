public class stringMatching {
    static public void SM(String s, String t) {
        int n = s.length();
        int m = t.length();

        for (int i = 0; i < n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (s.charAt(i + j) != t.charAt(j))
                    break;
            }
            if (j == m) {
                System.out.print("Pattern found at: " + i + "\n");
            }
        }
    }

    public static void main(String[] args) {
        // Example 1
        String txt1 = "AABAACAADAABAABA";
        String pat1 = "AABA";
        SM(txt1, pat1);
    }
}

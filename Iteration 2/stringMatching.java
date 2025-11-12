public class stringMatching {
    static public void SM(String s, String t) {
        int n = s.length();
        int m = t.length();
        for (int i = 0; i < n - m + 1; i++) {
            int j;
            for (j = 0; j < m; j++) {
                System.out.print(j);
                if (s.charAt(i + j) != t.charAt(j))
                    break;
            }
            System.out.println();
            if (j == m) {
                System.out.print("Match found at: " + i + "\n");
            }
        }
    }

    static public void main(String args[]) {
        String s = "Dhiraj is an asshole";
        String t = "asshole";
        SM(s, t);
    }
}

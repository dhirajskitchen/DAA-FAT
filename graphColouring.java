public class graphColouring {
    static int graph[][] = { { 0, 1, 1 }, { 1, 0, 1 }, { 1, 1, 0 } };
    static int colour[] = new int[3];

    static public boolean isSafe(int v, int c) {
        for (int i = 0; i < graph.length; i++)
            if (i != v && graph[i][v] == 1 && colour[i] == c)
                return false;
        return true;
    }

    static public boolean backtrack(int v) {
        if (v == graph.length)
            return true;
        for (int i = 1; i <= graph.length; i++) {
            if (isSafe(v, i)) {
                colour[v] = i;
                if (backtrack(v + 1))
                    return true;
                colour[v] = 0;
            }
        }
        return false;
    }

    static public void main(String args[]) {
        backtrack(0);
        for (int c : colour)
            System.out.print(c + " ");
    }
}

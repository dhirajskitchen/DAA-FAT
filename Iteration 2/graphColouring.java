public class graphColouring {
    static int graph[][];
    static int colour[];

    static public boolean isSafe(int v, int c) {
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            if (i != v && graph[v][i] == 1 && colour[i] == c)
                return false;
        }
        return true;
    }

    static public boolean colouring(int v) {
        if (v == graph.length) {
            // System.out.println("Hi");
            return true;
        }
        int n = graph.length;
        for (int c = 1; c <= n; c++) {
            // System.out.println("Hi");
            if (isSafe(v, c)) {
                colour[v] = c;
                if (colouring(v + 1))
                    return true;
                colour[v] = 0;
            }
        }
        return false;
    }

    static public void main(String args[]) {
        graph = new int[][] { { 0, 1, 1 }, { 1, 0, 1 }, { 1, 1, 0 } };
        colour = new int[graph.length];
        colouring(0);
        for (int i = 0; i < graph.length; i++)
            System.out.print(colour[i] + " ");
    }
}

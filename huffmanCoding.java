import java.util.*;

class Node {
    int freq;
    char ch;
    Node left, right;

    Node(int n, char c) {
        freq = n;
        ch = c;
    }
}

class huffmanCoding {
    static public void preOrder(List<String> res, Node root, String curr) {
        if (root != null) {
            if (root.ch != '-')
                res.add(curr);

            preOrder(res, root.left, curr + '0');
            preOrder(res, root.right, curr + '1');
        }
    }

    static public List<String> hmc(String s, int freq[]) {
        List<String> codes = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.freq < b.freq)
                return -1;
            else
                return 1;
        });
        for (int i = 0; i < s.length(); i++) {
            Node temp = new Node(freq[i], s.charAt(i));
            pq.add(temp);
        }
        while (pq.size() > 1) {
            Node n1 = pq.poll();
            Node n2 = pq.poll();
            Node newNode = new Node(n1.freq + n2.freq, '-');
            newNode.left = n1;
            newNode.right = n2;
            pq.add(newNode);
        }
        Node root = pq.poll();
        preOrder(codes, root, "");
        return codes;
    }

    public static void main(String[] args) {
        String s = "abcdef";
        int[] freq = { 5, 9, 12, 13, 16, 45 };
        List<String> ans = hmc(s, freq);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(s.charAt(i) + " " + ans.get(i) + "\n");
        }
    }
}
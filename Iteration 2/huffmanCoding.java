import java.util.*;

class Node {
    int freq;
    char ch;
    Node left, right;

    Node(int x, char y) {
        freq = x;
        ch = y;
    }
}

public class huffmanCoding {
    static public void preorder(HashMap<Character, String> hm, String curr, Node root) {
        if (root != null) {
            // System.err.println("Hi");
            if (root.ch != '-') {
                hm.put(root.ch, curr);
            }
            preorder(hm, curr + "0", root.left);
            preorder(hm, curr + "1", root.right);
        }
    }

    static public HashMap<Character, String> HC(String s, int freq[]) {
        HashMap<Character, String> code = new HashMap<>();
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
        while (pq.size() >= 2) {
            Node nl = pq.poll();
            Node nr = pq.poll();
            Node newNode = new Node(nl.freq + nr.freq, '-');
            newNode.left = nl;
            newNode.right = nr;
            pq.add(newNode);
        }
        Node root = pq.poll();
        preorder(code, "", root);
        return code;
    }

    static public void main(String args[]) {
        String s = "abcde";
        int[] freq = { 5, 9, 7, 1, 6 };
        HashMap<Character, String> hm = HC(s, freq);
        for (char c : s.toCharArray()) {
            System.out.print(c + " " + hm.get(c) + "\n");
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, a, b, c, cnt = 0;
    static List<Node> tree;
    static List<Integer> inorderList = new ArrayList<>();
    static boolean[] visited;
    static int[] parent;
    static int lastInorder;

    static class Node {
        int left, right;
        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        parent = new int[n + 1];
        visited = new boolean[n + 1];

        // 인덱스 접근을 위해 0번 인덱스는 더미 노드 추가
        tree.add(new Node(-1, -1)); // index 0

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            while (tree.size() <= a) tree.add(new Node(-1, -1));
            tree.set(a, new Node(b, c));

            if (b != -1) parent[b] = a;
            if (c != -1) parent[c] = a;
        }

        inorder(1);
        lastInorder = inorderList.get(inorderList.size() - 1);

        simulate(1);

        System.out.println(cnt);
    }

    static void inorder(int cur) {
        if (cur == -1) return;
        inorder(tree.get(cur).left);
        inorderList.add(cur);
        inorder(tree.get(cur).right);
    }

    static void simulate(int cur) {
        visited[cur] = true;


        while (true) {

            int left = tree.get(cur).left;
            int right = tree.get(cur).right;


            if (left != -1 && !visited[left]) {
                cnt++;
                cur = left;
                visited[cur] = true;
            }
            else if (right != -1 && !visited[right]) {
                cnt++;
                cur = right;
                visited[cur] = true;
            } else if (cur == lastInorder) {
                break;
            }
            else {
                cnt++;
                cur = parent[cur];
            }
        }
    }
}

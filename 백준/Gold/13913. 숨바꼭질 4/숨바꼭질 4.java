import java.util.*;

public class Main {

    static int n, k;
    static boolean[] visited;
    static int[] parent;
    static int max = 100000;

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        k = scan.nextInt();

        visited = new boolean[max + 1];
        parent = new int[max + 1];
        Arrays.fill(parent, -1);

        int minTime = bfs();
        System.out.println(minTime);
        printPath();
    }

    public static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(n, 0));
        visited[n] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.x == k) {
                return node.time;
            }

            int[] nextPositions = {node.x * 2, node.x + 1, node.x - 1};
            for (int next : nextPositions) {
                if (next >= 0 && next <= max && !visited[next]) {
                    q.offer(new Node(next, node.time + 1));
                    visited[next] = true;
                    parent[next] = node.x;
                }
            }
        }
        return -1;
    }

    public static void printPath() {
        List<Integer> path = new ArrayList<>();
        for (int at = k; at != -1; at = parent[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        for (int pos : path) {
            System.out.print(pos + " ");
        }
        System.out.println();
    }

    public static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
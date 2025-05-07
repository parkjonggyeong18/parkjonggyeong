import java.io.*;
import java.util.*;

public class Main {
    static List<int[]>[] list;
    static boolean[] visited;
    static int max;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        list = new List[10001];
        for (int i = 0; i < 10001; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[10001];
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            StringTokenizer st = new StringTokenizer(line);
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new int[]{v, w});
            list[v].add(new int[]{u, w});
        }
        
        dfs(1, 0);

        visited = new boolean[10001];
        max = 0;
        dfs(result, 0);
        System.out.println(max);
    }

    private static void dfs(int node, int distance) {
        visited[node] = true;
        if (distance > max) {
            max = distance;
            result = node;
        }
        for (int[] edge : list[node]) {
            int nextNode = edge[0];
            int weight = edge[1];
            if (!visited[nextNode]) {
                dfs(nextNode, distance + weight);
            }
        }
    }
}
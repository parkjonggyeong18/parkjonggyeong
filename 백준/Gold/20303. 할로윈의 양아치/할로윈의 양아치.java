import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, k, c[], a, b, dp[];
    static List<Integer>[] graph;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        v = new boolean[n];
        c = new int[n];
        dp = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            graph[a].add(b);
            graph[b].add(a);
        }

        List<int[]> group = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(!v[i]) {
                group.add(bfs(i));

            }
        }

        for (int[] g : group) {
            if (g[0] < k) {
                for (int i = k - 1; i >= g[0]; i--) {
                    dp[i] = Math.max(dp[i], dp[i- g[0]] + g[1]);
                }
            }
        }
        System.out.println(dp[k -1]);
    }

    private static int[] bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        v[start] = true;

        int count = 1;
        int sum = c[start];

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (!v[next]) {
                    v[next] = true;
                    q.add(next);
                    count++;
                    sum += c[next];
                }
            }
        }

        return new int[]{count, sum};
    }
}
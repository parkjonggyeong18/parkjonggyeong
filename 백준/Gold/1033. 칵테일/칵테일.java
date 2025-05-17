import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<int[]>[] graph;
    static boolean[] visited;
    static long[] numerators;   // 분자
    static long[] denominators; // 분모

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n];
        visited = new boolean[n];
        numerators = new long[n];
        denominators = new long[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, p, q});
            graph[b].add(new int[]{a, q, p}); // 역방향도 반대 비율로
        }

        numerators[0] = 1;
        denominators[0] = 1;
        dfs(0);

        // 전체 LCM 구하기
        long lcm = denominators[0];
        for (int i = 1; i < n; i++) {
            lcm = lcm(lcm, denominators[i]);
        }

        for (int i = 0; i < n; i++) {
            long factor = lcm / denominators[i];
            System.out.print((numerators[i] * factor) + " ");
        }
    }

    private static void dfs(int node) {
        visited[node] = true;

        for (int[] edge : graph[node]) {
            int next = edge[0];
            int p = edge[1];
            int q = edge[2];

            if (!visited[next]) {
                numerators[next] = numerators[node] * q;
                denominators[next] = denominators[node] * p;

                long gcd = gcd(numerators[next], denominators[next]);
                numerators[next] /= gcd;
                denominators[next] /= gcd;

                dfs(next);
            }
        }
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    private static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}

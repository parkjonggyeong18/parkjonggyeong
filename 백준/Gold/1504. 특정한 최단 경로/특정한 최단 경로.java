import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.*;

public class Main {
    static int n, e, a, b, c, v1, v2;
    static List<Point>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        arr = new LinkedList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            arr[i] = new LinkedList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            arr[a].add(new Point(b, c));
            arr[b].add(new Point(a, c));

        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int[] route = di(1);
        int[] route1 = di(v1);
        int[] route2 = di(v2);

        long result = Math.min((long)route[v1] + route1[v2] + route2[n], (long)route[v2] + route2[v1] + route1[n]);
        System.out.println(result >= Integer.MAX_VALUE ? -1 : result);
    }

    private static int[] di(int i) {
        int[] dist = new int[n + 1];
        for (int j = 0; j < n + 1; j++) {
            dist[j] = Integer.MAX_VALUE;
        }
        dist[i] = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, 0));
        while (!q.isEmpty()) {
            Point p = q.poll();
            int cur = p.x;
            int cost = p.y;
            for (Point next : arr[cur]) {
                if (dist[next.x] > dist[cur] + next.y) {
                    dist[next.x] = dist[cur] + next.y;
                    q.add(new Point(next.x, dist[next.x]));
                }
            }
        }
        return dist;
    }

}
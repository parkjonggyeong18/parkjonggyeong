import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int t, l, x1, x2, y1, y2;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());


        for (int i = 0; i < t; i++) {
            l = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            System.out.println(bfs());
        }
    }

    private static int bfs() {
        boolean[][] visited = new boolean[l][l];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x1, y1, 0});
        visited[x1][y1] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            int cnt = p[2];

            if (x == x2 && y == y2) {
                return cnt;
            }

            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= l || ny < 0 || ny >= l) {
                    continue;
                }
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cnt + 1});
                }
            }
        }
        return -1;
    }
}
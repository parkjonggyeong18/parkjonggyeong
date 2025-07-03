import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;
import java.util.List;

public class Main {
    static int n, m, miro[][];
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
       miro = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                miro[i][j] = input.charAt(j) - '0';
            }
        }
        int result = bfs(0, 0);
        System.out.println(result);
    }

    private static int bfs(int x, int y) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] v = new boolean[n][m];
        q.offer(new int[]{x, y, 0});
        v[x][y] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();

            if(p[0] == n - 1 && p[1] == m - 1) {
                return p[2];
            }

            for (int d = 0; d < 4; d++) {
                int nx = p[0] + dx[d];
                int ny = p[1] + dy[d];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !v[nx][ny]) {
                    if(miro[nx][ny] == 0) {
                        v[nx][ny] = true;
                        q.offer(new int[]{nx, ny, p[2]});
                    }
                    if (miro[nx][ny] == 1) {
                        v[nx][ny] = true;
                        q.offer(new int[]{nx, ny, p[2] + 1});
                    }
                }
            }

        }
        return 0;
    }
}
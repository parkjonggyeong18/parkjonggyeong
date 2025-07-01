import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] a;
    static int len = 0;
    static int ans = 0;
    static boolean[][] v;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                a[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        for (int r = 0; r < n; r++) {

            for (int c = 0; c < m; c++) {
                if (a[r][c] != 0) {
                    bfs(r, c);
                }

            }
        }
        System.out.println(ans);
    }

    private static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        v = new boolean[n][m];
        q.add(new int[]{r, c, 0});
        v[r][c] = true;
        int max = -1;
        while (!q.isEmpty()) {
            int[] p = q.poll();

            max = Math.max(max, a[p[0]][p[1]]);
            for (int d = 0; d < 4; d++) {
                int nx = p[0] + dx[d];
                int ny = p[1] + dy[d];

                if (0 <= nx && nx < n && 0 <= ny && ny < m && !v[nx][ny] && a[nx][ny] != 0) {
                    v[nx][ny] = true;
                    

                    if (len < p[2] + 1) {
                        len = p[2] + 1;
                        ans = a[r][c] + a[nx][ny];
                    } else if (len == p[2] + 1) {
                        ans = Math.max(ans, a[r][c] + a[nx][ny]);
                    }


                    q.add(new int[]{nx, ny, p[2] + 1});


                }
            }


        }

    }
}
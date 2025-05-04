import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int r, c, k, cnt = 0;
    static char[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }
        visited[r -1][0] = true;
        dfs(r -1, 0, 1);

        System.out.println(cnt);
    }

    private static void dfs(int x, int y, int distance) {
        if (x == 0 && y == c - 1) {
            if (distance == k) {
                cnt++;
            }
            return;
        }
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny] && map[nx][ny] == '.') {
                visited[nx][ny] = true;
                dfs(nx, ny, distance + 1);
                visited[nx][ny] = false;

            }

        }

    }

}
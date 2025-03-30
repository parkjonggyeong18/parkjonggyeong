import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N, H;
    static int[][][] grid;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        grid = new int[H][N][M];

        Queue<int[]> queue = new LinkedList<>();
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    grid[h][n][m] = Integer.parseInt(st.nextToken());
                    if (grid[h][n][m] == 1) {
                        queue.add(new int[]{h, n, m});
                    }
                }
            }
        }

        System.out.println(bfs(queue));
    }

    private static int bfs(Queue<int[]> queue) {
        int days = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int z = current[0];
                int y = current[1];
                int x = current[2];

                for (int j = 0; j < 6; j++) {
                    int nz = z + dz[j];
                    int ny = y + dy[j];
                    int nx = x + dx[j];

                    if (nz >= 0 && nz < H && ny >= 0 && ny < N && nx >= 0 && nx < M && grid[nz][ny][nx] == 0) {
                        grid[nz][ny][nx] = 1;
                        queue.add(new int[]{nz, ny, nx});
                    }
                }
            }
            days++;
        }

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (grid[h][n][m] == 0) {
                        return -1;
                    }
                }
            }
        }
        if (days == -1 ){
             return 0;
        }
        return days;
    }
}
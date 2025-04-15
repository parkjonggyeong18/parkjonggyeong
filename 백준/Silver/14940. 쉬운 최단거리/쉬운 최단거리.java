import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map, distance;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];

        int startX = 0, startY = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
                if (map[i][j] == 0) {
                    distance[i][j] = 0; // 갈 수 없는 땅은 0으로 초기화
                } else {
                    distance[i][j] = -1; // 초기값은 -1로 설정
                }
            }
        }

        bfs(startX, startY);

        // 결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        distance[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
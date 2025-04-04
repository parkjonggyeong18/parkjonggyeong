import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, maxEven, maxOdd;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, -1};
    static int[] dc = {-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][n];

        maxEven = 0;
        maxOdd = 0;

        backtracking(0, 0, 0, true);
        backtracking(0, 1, 0, false);

        System.out.println(maxEven + maxOdd);
    }

    private static void backtracking(int r, int c, int count, boolean isEven) {
        if (r >= n) {
            if (isEven) maxEven = Math.max(maxEven, count);
            else maxOdd = Math.max(maxOdd, count);
            return;
        }
        if (c >= n) {
            backtracking(r+1, (isEven) ? (r+1) % 2 : 1 - (r+1) % 2, count, isEven);
            return;
        }

        if ((r + c) % 2 != (isEven ? 0 : 1)) {
            backtracking(r, c+2, count, isEven);
            return;
        }

        if (map[r][c] == 1 && check(r, c)) {
            visited[r][c] = true;
            backtracking(r, c+2, count+1, isEven);
            visited[r][c] = false;
        }
        backtracking(r, c+2, count, isEven);
    }
    private static boolean check(int row, int col) {
        for (int i = 0; i < 2; i++) {
            int r = row, c = col;
            while (true) {
                r += dr[i];
                c += dc[i];
                if (r < 0 || r >= n || c < 0 || c >= n) break;
                if (visited[r][c]) return false;
            }
        }
        return true;
    }

}

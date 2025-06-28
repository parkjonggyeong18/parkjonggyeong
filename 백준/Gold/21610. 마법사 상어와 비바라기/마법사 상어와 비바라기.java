import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, a[][], d, s;
    static boolean cloud[][], copy[][];
    // 1.←, 2.↖, 3.↑, 4.↗, 5.→, 6.↘, 7.↓, 8.↙
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n][n];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                a[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        cloud = new boolean[n][n];


        cloud[n - 1][0] = true;
        cloud[n - 1][1] = true;
        cloud[n - 2][0] = true;
        cloud[n - 2][1] = true;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken()) - 1;
            s = Integer.parseInt(st.nextToken());
            move(d, s);

        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += a[i][j];
            }
        }
        System.out.println(sum);

    }

    public static void move(int d, int s) {
        boolean[][] news = new boolean[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (cloud[r][c]) {
                    int nr = (r + dr[d] * s) % n;
                    if (nr < 0) {
                        nr += n;
                    }

                    int nc = (c + dc[d] * s) % n;
                    if (nc < 0) {
                        nc += n;
                    }
                    news[nr][nc] = true;

                }
            }
        }
        cloud = news;
        copy = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cloud[i][j]) {
                    a[i][j]++;
                    copy[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (copy[i][j]) {
                    for (int w = 1; w < 8; w += 2) {
                        int nr = i + dr[w];
                        int nc = j + dc[w];
                        if (0 <= nr && nr < n && 0 <= nc && nc < n && a[nr][nc] != 0) {
                            a[i][j]++;
                        }
                    }
                }
            }
        }
        boolean[][] mi = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!copy[i][j] && a[i][j] >= 2) {
                    mi[i][j] = true;
                    a[i][j] -= 2;
                }
            }
        }
        cloud = mi;
    }

}
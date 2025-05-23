import java.io.*;
import java.util.*;

public class Main {
    static int n, m, x, y, k, map[][];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[] dice = new int[6];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int command = Integer.parseInt(st.nextToken()) - 1;
            int nx = x + dx[command];
            int ny = y + dy[command];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }
            changeDice(command);

            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[1];
            } else {
                dice[1] = map[nx][ny];
                map[nx][ny] = 0;
            }
            x = nx;
            y = ny;
            System.out.println(dice[0]);
        }
    }

    private static void changeDice(int direction) {
        int[] temp = dice.clone();
        if (direction == 0) {
            dice[0] = temp[4];
            dice[1] = temp[5];
            dice[4] = temp[1];
            dice[5] = temp[0];
        } else if (direction == 1) {
            dice[0] = temp[5];
            dice[1] = temp[4];
            dice[4] = temp[0];
            dice[5] = temp[1];
        } else if (direction == 2) {
            dice[0] = temp[3];
            dice[1] = temp[2];
            dice[2] = temp[0];
            dice[3] = temp[1];
        } else if (direction == 3) {
            dice[0] = temp[2];
            dice[1] = temp[3];
            dice[2] = temp[1];
            dice[3] = temp[0];
        }
    }
}
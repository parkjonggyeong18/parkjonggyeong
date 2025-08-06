import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final int MAX = 1000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> players = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            StringTokenizer st = new StringTokenizer(line);
            int white = Integer.parseInt(st.nextToken());
            int black = Integer.parseInt(st.nextToken());
            players.add(new int[]{white, black});
        }

        int N = players.size();
        int[][][] dp = new int[N + 1][16][16]; // dp[i][w][b]

        for (int i = 0; i <= N; i++)
            for (int w = 0; w <= 15; w++)
                Arrays.fill(dp[i][w], -1);

        dp[0][0][0] = 0;

        for (int i = 0; i < N; i++) {
            int white = players.get(i)[0];
            int black = players.get(i)[1];

            for (int w = 0; w <= 15; w++) {
                for (int b = 0; b <= 15; b++) {
                    if (dp[i][w][b] == -1) continue;

                    // 선택 안함
                    dp[i + 1][w][b] = Math.max(dp[i + 1][w][b], dp[i][w][b]);

                    // 백 선택
                    if (w + 1 <= 15)
                        dp[i + 1][w + 1][b] = Math.max(dp[i + 1][w + 1][b], dp[i][w][b] + white);

                    // 흑 선택
                    if (b + 1 <= 15)
                        dp[i + 1][w][b + 1] = Math.max(dp[i + 1][w][b + 1], dp[i][w][b] + black);
                }
            }
        }

        System.out.println(dp[N][15][15]);
    }
}

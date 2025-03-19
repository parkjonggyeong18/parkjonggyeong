import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        long[][] grid = new long[N][M];
        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                grid[i][j] = Long.parseLong(tokens[j]);
            }
        }
        
        long[] dp = new long[M];

        dp[0] = grid[0][0];
        for (int j = 1; j < M; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        for (int i = 1; i < N; i++) {
            long[] left = new long[M];
            long[] right = new long[M];

            left[0] = dp[0] + grid[i][0];
            for (int j = 1; j < M; j++) {
                left[j] = Math.max(dp[j], left[j - 1]) + grid[i][j];
            }

            right[M - 1] = dp[M - 1] + grid[i][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                right[j] = Math.max(dp[j], right[j + 1]) + grid[i][j];
            }

            for (int j = 0; j < M; j++) {
                dp[j] = Math.max(left[j], right[j]);
            }
        }
        System.out.println(dp[M - 1]);
    }
}

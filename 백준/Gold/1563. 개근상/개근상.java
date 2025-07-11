import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int n, dp[][][], res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][2][3];

        dp[1][0][0] = 1;
        dp[1][1][0] = 1;
        dp[1][0][1] = 1;
        res = 3;
        for (int i = 2; i<= n; i++) {
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) %1000000;
            dp[i][0][1] = dp[i - 1][0][0] %1000000;
            dp[i][0][2] = dp[i - 1][0][1] %1000000;
            dp[i][1][0] = (dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2] + dp[i-1][1][0] + dp[i-1][1][1] + dp[i-1][1][2]) %1000000;
            dp[i][1][1] = dp[i - 1][1][0] %1000000;
            dp[i][1][2] = dp[i - 1][1][1] %1000000;
            res = 0;
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    res = (res + dp[i][j][k]) % 1000000;

                }
            }
        }
        System.out.println(res);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static double[] arr, dp;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new double[n + 1];
        dp = new double[n + 1];
        double max = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
            dp[i] = Math.max(arr[i], dp[i - 1] * arr[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(String.format("%.3f", max));
    }
}

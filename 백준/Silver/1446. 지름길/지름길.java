import java.io.*;
import java.util.*;

public class Main {
    static int n, d;
    static int[] dp;
    static List<int[]> shortcuts = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        dp = new int[d + 1];
        for (int i = 0; i <= d; i++) {
            dp[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            if (end <= d) {
                shortcuts.add(new int[]{start, end, length});
            }
        }

        for (int i = 0; i <= d; i++) {
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }
            for (int[] shortcut : shortcuts) {
                int start = shortcut[0];
                int end = shortcut[1];
                int length = shortcut[2];

                if (i == start) {
                    dp[end] = Math.min(dp[end], dp[i] + length);
                }
            }
        }
        System.out.println(dp[d]);
    }
}
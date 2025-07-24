import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int n, health = 100, happy;
    static int[][] person;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        person = new int[n][2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            person[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            person[i][1] = Integer.parseInt(st.nextToken());
        }
        dp = new int[101];
        System.out.println(dp());

    }

    private static int dp() {


        for (int i = 0; i < n; i++) {
            for(int j = 99; j >= person[i][0]; j--){
                if(j - person[i][0] >= 0){
                    dp[j] = Math.max(dp[j], dp[j - person[i][0]] + person[i][1]);
                }
            }
        }
        int max = 0;
        for (int i = 1; i < 100; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int C = Integer.parseInt(line[0]);
        int N = Integer.parseInt(line[1]);
        int[][] arr = new int[N][2];
        int[] dp = new int[C+100]; // C+100까지의 범위가 중요

        for(int i=0; i<C+100; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i=0; i<N; i++) {
            line = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(line[0]); // 홍보 비용
            arr[i][1] = Integer.parseInt(line[1]); // 고객 수
        }

        dp[0] = 0;
        for(int i=0; i<N; i++) {
            int cost = arr[i][0];
            int num = arr[i][1];
            for(int j=num; j<C+100; j++) {
                if(dp[j-num] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - num] + cost);
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for(int i=C; i<C+100; i++) {
            minCost = Math.min(dp[i], minCost);
        }
        System.out.println(minCost);
    }
}
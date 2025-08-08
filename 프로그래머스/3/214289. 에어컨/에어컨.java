import java.util.*;

class Solution {
    static int max = 100 * 1000 + 1;
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        int answer = max;
        int depth = onboard.length;
        t1 += 10;
        t2 += 10;
        temperature += 10;
        int dp[][] = new int[depth][51];
        
        for(int i = 0; i < depth; i++){
            Arrays.fill(dp[i], max);
        }
        dp[0][temperature] = 0;
    
        for (int i = 1; i < depth; i++) {
            for (int j = 0; j <= 50; j++) {
                int min = max;
                if (onboard[i] == 1 && (j < t1 || t2 < j)) continue;
                
                if (j == temperature) {
                    min = Math.min(dp[i - 1][j], min);
                }
                if (t1 <= j && j <= t2) {
                   min = Math.min(dp[i - 1][j] + b, min);
                }
                if ((0 <= j + 1 && j+ 1 <= 50) && temperature <= t2) {
                    min = Math.min(min, dp[i - 1][j + 1]);
                }
                if ((0 <= j - 1 && j - 1 <= 50) && temperature > t2) {
                    min = Math.min(min, dp[i - 1][j - 1]);
                }
                
                if ((0 <= j + 1 && j+ 1 <= 50) && temperature > t2) {
                    min = Math.min(min, dp[i - 1][j + 1] + a);
                }
                if ((0 <= j - 1 && j - 1 <= 50) && temperature <= t2) {
                    min = Math.min(min, dp[i - 1][j - 1] + a);
                }
                dp[i][j] = min;
            }
        }
        for (int i = 1; i <= 50; i++) {
            answer = Math.min(dp[onboard.length - 1][i], answer);
        }
        
        
        return answer;
    }
}
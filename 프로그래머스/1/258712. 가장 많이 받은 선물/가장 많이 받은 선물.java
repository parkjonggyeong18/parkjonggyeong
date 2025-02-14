import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        Map<String, Integer> friendIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            friendIdx.put(friends[i], i);
        }

        int[][] giftLog = new int[n][n];
        int[] giftPoint = new int[n];
        for (String gift : gifts) {
            String[] g = gift.split(" ");
            int giver = friendIdx.get(g[0]);
            int taker = friendIdx.get(g[1]);

            giftLog[giver][taker]++;
            giftPoint[giver]++;
            giftPoint[taker]--;
        }

        int[] nextMonth = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (giftLog[i][j] > giftLog[j][i]) {
                    nextMonth[i]++;
                } else if (giftLog[i][j] < giftLog[j][i]) {
                    nextMonth[j]++;
                } else {
                    if (giftPoint[i] > giftPoint[j]) {
                        nextMonth[i]++;
                    } else if (giftPoint[i] < giftPoint[j]) {
                        nextMonth[j]++;
                    }
                }
            }
        }
        
        return Arrays.stream(nextMonth).max().orElse(0);
    }
}

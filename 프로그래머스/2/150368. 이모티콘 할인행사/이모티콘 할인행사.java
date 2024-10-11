import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int[] answer = {0, 0};
    private List<int[]> discount = new ArrayList<>();
    private int[] data = {10, 20, 30, 40};

    // DFS 탐색 함수
    public void dfs(int[] tmp, int d, int emoticonCount) {
        if (d == emoticonCount) {
            discount.add(tmp.clone()); // 현재 상태를 리스트에 추가
            return;
        } else {
            for (int i : data) {
                tmp[d] += i;
                dfs(tmp, d + 1, emoticonCount);
                tmp[d] -= i;
            }
        }
    }

    public int[] solution(int[][] users, int[] emoticons) {
        int emoticonCount = emoticons.length;
        
        // DFS 탐색 시작
        dfs(new int[emoticonCount], 0, emoticonCount);
        
        // 각 할인율 조합에 대해 계산
        for (int[] d : discount) {
            int totalPay = 0;
            int cnt = 0;
            
            for (int[] user : users) {
                int pay = 0;
                
                for (int j = 0; j < d.length; j++) {
                    if (user[0] <= d[j]) {
                        pay += emoticons[j] * (100 - d[j]) / 100.0;
                    }
                    if (pay >= user[1]) {
                        break;
                    }
                }
                
                if (pay >= user[1]) {
                    pay = 0;
                    cnt++;
                }
                totalPay += pay;
            }
            
            // 최대 가입자 수 및 총 판매금액 업데이트
            if (cnt >= answer[0]) {
                if (cnt == answer[0]) {
                    answer[1] = Math.max(answer[1], totalPay);
                } else {
                    answer[1] = totalPay;
                }
                answer[0] = cnt;
            }
        }

        return answer;
    }
}

import java.util.*;
class Solution {
    static int max, min;
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        System.out.println(lottos + ":" + max);
        max = 0;
        min = 0;
        for(int i = 0; i < lottos.length; i++){
            for(int j = 0; j <  win_nums.length; j++){
                if(lottos[i] == 0){
                max += 1;
                    break;
                }
                else if(lottos[i] == win_nums[j]){
                    max += 1;
                    min += 1;
                    break;
                }
        }
        }
        System.out.println(min + ":" + max);
        if(min == 6){
            answer[1] = 1;
        }
        else if(min == 5){
            answer[1] = 2;
        }
         else if(min == 4){
            answer[1] = 3;
        }
         else if(min == 3){
            answer[1] = 4;
        }
         else if(min == 2){
            answer[1] = 5;
        }else {
             answer[1] = 6;
         }
        if(max == 6){
            answer[0] = 1;
        }
        else if(max== 5){
            answer[0] = 2;
        }
         else if(max == 4){
            answer[0] = 3;
        }
         else if(max == 3){
            answer[0] = 4;
        }
         else if(max == 2){
            answer[0] = 5;
        }else{
             answer[0] = 6;
         }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    class Task {
        String name;
        int start, playtime;
        
        public Task(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }
    
    // 시간 변환 함수 (HH:mm -> 분으로 변환)
    public static int change(String c) {
        String[] temp = c.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }
    
    public String[] solution(String[][] plans) {
        int n = plans.length;
        String[] answer = new String[n];
        Task[] tasks = new Task[n];
        
        // 모든 작업을 Task 객체로 변환 후 시작 시간 기준으로 정렬
        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(plans[i][0], change(plans[i][1]), Integer.parseInt(plans[i][2]));
        }
        
        Arrays.sort(tasks, (o1, o2) -> o1.start - o2.start);
        
        int idx = 0, now = tasks[0].start;
        Stack<Task> stack = new Stack<>();
        
        // 현재 진행 중인 작업
        Task currentTask = tasks[0];
        int taskIdx = 1;  // 다음 실행할 작업의 인덱스
        
        while (true) {
            // 남은 작업 중 시작 시간이 현재 시간보다 작은 작업이 있는지 확인
            if (taskIdx < n && now + currentTask.playtime > tasks[taskIdx].start) {
                // 현재 작업을 중단하고, 남은 시간을 스택에 저장
                stack.push(new Task(currentTask.name, currentTask.start, currentTask.playtime - (tasks[taskIdx].start - now)));
                now = tasks[taskIdx].start;
                currentTask = tasks[taskIdx++];
            } else {
                // 현재 작업 완료
                answer[idx++] = currentTask.name;
                now += currentTask.playtime;
                
                // 다음 작업이 바로 시작되는지 확인
                if (taskIdx < n && now == tasks[taskIdx].start) {
                    currentTask = tasks[taskIdx++];
                } else if (!stack.isEmpty()) {
                    // 중단된 작업이 있으면 다시 시작
                    currentTask = stack.pop();
                } else if (taskIdx < n) {
                    // 남은 작업이 있으면 다음 작업으로 이동
                    currentTask = tasks[taskIdx++];
                    now = currentTask.start;
                } else {
                    // 더 이상 할 작업이 없으면 종료
                    break;
                }
            }
        }
        
        return answer;
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static class Task implements Comparable<Task> {
        int time, deadline;

        Task(int time, int deadline) {
            this.time = time;
            this.deadline = deadline;
        }

        @Override
        public int compareTo(Task other) {
            return other.deadline - this.deadline; // 마감 시간 내림차순 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Task[] tasks = new Task[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            tasks[i] = new Task(t, s);
        }
        
        Arrays.sort(tasks);
        
        int currentTime = Integer.MAX_VALUE;
        for (Task task : tasks) {
            currentTime = Math.min(currentTime, task.deadline) - task.time;
            if (currentTime < 0) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(currentTime);
    }
}
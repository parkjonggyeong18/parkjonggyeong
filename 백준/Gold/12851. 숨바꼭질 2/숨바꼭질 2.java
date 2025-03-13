import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, k, next;
    static int MAX = 100000;
    static int[] time = new int[MAX + 1];
    static int[] ways = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (n == k) {
            System.out.println(0);
            System.out.println(1);
            return;
        }
        bfs(n, k);
        System.out.println(time[k]);
        System.out.println(ways[k]);
    }

    private static void bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        time[start] = 0;
        ways[start] = 1;
        while (!q.isEmpty()) {
            int p = q.poll();
            for (int next : new int[]{p - 1, p + 1, 2 * p}) {
                if (next < 0 || next > MAX){
                    continue;
                }
                if(time[next] == 0){
                    q.add(next);
                    time[next] = time[p] + 1;
                    ways[next] += ways[p];
                } else if (time[next] == time[p] + 1) {
                    ways[next] += ways[p];
                }
            }
        }
    }

}
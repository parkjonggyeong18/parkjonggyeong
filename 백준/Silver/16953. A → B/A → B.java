import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static long a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        bfs();
    }

    private static void bfs() {
        Queue<long[]> q = new LinkedList<>();
        q.add(new long[]{a, 1});
        while (!q.isEmpty()) {
            long[] cur = q.poll();
            long num = cur[0];
            int cnt = (int) cur[1];
            if (num == b) {
                System.out.println(cnt);
                return;
            }
            if (num * 2 <= b) {
                q.add(new long[]{num * 2, cnt + 1});
            }
            if (num * 10 + 1 <= b) {
                q.add(new long[]{num * 10 + 1, cnt + 1});
            }
        }
        System.out.println(-1);
    }
}

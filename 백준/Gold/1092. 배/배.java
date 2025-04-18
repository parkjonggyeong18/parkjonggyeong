import java.io.*;
import java.util.*;

public class Main {

    static int n, m, cr[], box[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        cr = new int[n];
        for (int i = 0; i < n; i++) {
            cr[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        box = new int[m];
        for (int i = 0; i < m; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cr);
        Arrays.sort(box);

        for (int i  = 0; i < n / 2; i++) {
            int temp = cr[i];
            cr[i] = cr[n - i - 1];
            cr[n - i - 1] = temp;
        }
        for (int i  = 0; i < m / 2; i++) {
            int temp = box[i];
            box[i] = box[m - i - 1];
            box[m - i - 1] = temp;
        }
        if (box[0] > cr[0]){
            System.out.println(-1);
            return;
        }
        int time = 0;
        boolean[] visited = new boolean[m];
        int idx = 0;
        while (idx < m) {
            int create = 0;
            for (int i =0; i < m; i++) {
                if (!visited[i] && create < n && cr[create] >= box[i]) {
                    visited[i] = true;
                    create++;
                    idx++;
                }
                if(create == n) {
                    break;
                }

            }
            time++;
        }
        System.out.println(time);
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, arr[], max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] order = new int[n];
        boolean[] used = new boolean[n];
        perm(0, order, used);
        System.out.println(max);
    }
    
    private static void perm(int count, int[] order, boolean[] used) {
        if (count == n) {
            evaluate(order);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                order[count] = arr[i];
                perm(count + 1, order, used);
                used[i] = false;
            }
        }
    }
    
    private static void evaluate(int[] order) {
        boolean[] boundary = new boolean[100];
        int sum = 0;
        boundary[0] = true;
        for (int i = 0; i < n - 1; i++) {
            sum += order[i];
            boundary[sum % 100] = true;
        }
        int count = 0;
        for (int p = 0; p < 100; p++) {
            if (boundary[p] && boundary[(p + 50) % 100]) {
                count++;
            }
        }
        max = Math.max(max, count / 2);
    }
}

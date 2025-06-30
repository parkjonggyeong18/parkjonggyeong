import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int avg[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        avg = new int[n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine().replace(".", "");
            avg[i] = Integer.parseInt(s);
        }

        for (int i = 1; i <= 10000000; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                int low = avg[j] * i;
                int high = (avg[j] + 1) * i - 1;
                int start = ((low + 999) / 1000) * 1000;
                if (start > high) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println(i);
                return;
            }
        }
    }
}
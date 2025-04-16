import java.io.*;
import java.util.*;

public class Main {
    static int n, c, w;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        arr = new int[n];

        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxLength = Math.max(maxLength, arr[i]);
        }

        long maxProfit = 0;

        for (int length = 1; length <= maxLength; length++) {
            long currentProfit = 0;

            for (int tree : arr) {
                if (tree < length) continue;

                int pieces = tree / length;
                int cuts = pieces - (tree % length == 0 ? 1 : 0);
                long revenue = (long) pieces * length * w;
                long cost = (long) cuts * c;

                if (revenue > cost) {
                    currentProfit += (revenue - cost);
                }
            }

            maxProfit = Math.max(maxProfit, currentProfit);
        }

        System.out.println(maxProfit);
    }
}
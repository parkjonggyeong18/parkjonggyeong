import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static String[] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        table = new String[n];

        for (int i = 0; i < n; i++) {
            table[i] = br.readLine();
        }

        k = Integer.parseInt(br.readLine());

        Map<String, Integer> rowCount = new HashMap<>();
        for (String row : table) {
            rowCount.put(row, rowCount.getOrDefault(row, 0) + 1);
        }

        int maxRows = 0;
        for (String row : rowCount.keySet()) {
            int zeroCount = 0;
            for (char c : row.toCharArray()) {
                if (c == '0') zeroCount++;
            }

            if (zeroCount <= k && (k - zeroCount) % 2 == 0) {
                maxRows = Math.max(maxRows, rowCount.get(row));
            }
        }

        System.out.println(maxRows);
    }
}
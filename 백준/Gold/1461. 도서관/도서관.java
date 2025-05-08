import java.io.*;
import java.util.*;

public class Main {
    static int n, m, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int book = Integer.parseInt(st.nextToken());
            if (book < 0) {
                negative.add(-book);
            } else {
                positive.add(book);
            }
        }
        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative, Collections.reverseOrder());
        cnt = 0;

        for (int i = 0; i < positive.size(); i += m) {
            cnt += positive.get(i) * 2;
        }
        for (int i = 0; i < negative.size(); i += m) {
            cnt += negative.get(i) * 2;
        }
        int max = 0;
        if (positive.size() > 0) {
            max = Math.max(max, positive.get(0));
        }
        if (negative.size() > 0) {
            max = Math.max(max, negative.get(0));
        }
        cnt -= max;
        System.out.println(cnt);
    }
}
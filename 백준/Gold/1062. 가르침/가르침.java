import java.io.*;
import java.util.*;

public class Main {
    static int n, k, max = 0;
    static String[] words;
    static boolean[] learned = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine().replaceAll("[antic]", ""); // 필수 글자 제거
        }

        if (k < 5) {
            System.out.println(0);
            return;
        }

        if (k == 26) {
            System.out.println(n);
            return;
        }

        // 필수 글자 학습
        learned['a' - 'a'] = true;
        learned['n' - 'a'] = true;
        learned['t' - 'a'] = true;
        learned['i' - 'a'] = true;
        learned['c' - 'a'] = true;

        backtrack(0, 0);
        System.out.println(max);
    }

    private static void backtrack(int idx, int count) {
        if (count == k - 5) { 
            int readable = 0;
            for (String word : words) {
                boolean canRead = true;
                for (char c : word.toCharArray()) {
                    if (!learned[c - 'a']) {
                        canRead = false;
                        break;
                    }
                }
                if (canRead) readable++;
            }
            max = Math.max(max, readable);
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (!learned[i]) {
                learned[i] = true;
                backtrack(i + 1, count + 1);
                learned[i] = false;
            }
        }
    }
}
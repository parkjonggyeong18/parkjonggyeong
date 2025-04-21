import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0;
    static char[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        arr = s.toCharArray();
        Arrays.sort(arr);
        visited = new boolean[arr.length];
        dfs("", 0);
        System.out.println(cnt);
    }

    private static void dfs(String word, int depth) {
        if (depth == arr.length) {
            if (luck(word)) {
                cnt++;
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue; 
            visited[i] = true;
            dfs(word + arr[i], depth + 1);
            visited[i] = false;
        }
    }

    private static boolean luck(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
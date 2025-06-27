import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static String a;
    static char[] len;
    static Stack<Character> st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        len = a.toCharArray();
        st = new Stack<>();

        System.out.println(cal(0, len.length));
    }

    private static int cal(int start, int end) {
        int depth = 0;
        for (int i = start; i < end; i++) {
            char c = len[i];
            if (c == ')') {
                return depth;
            } else if (c == '(') {
                continue;
            }
            if (i + 1 < end && len[i + 1] == '(') {
                int k = c - '0';
                int j = i + 2;
                int open = 1;

                while (j < end) {
                    if (len[j] == '(') {
                        open++;
                    } else if (len[j] == ')') {
                        open--;
                    }
                    if (open == 0) {
                        break;
                    }
                    j++;
                }
                int newLenth = cal(i + 2, j);
                depth += (k * newLenth);
                i = j;

            } else {
                depth++;
            }

        }
        return depth;
    }
}

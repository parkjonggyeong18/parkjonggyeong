import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static boolean v = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        back("");

    }

    private static void back(String res) {
        if (v) {
            return;
        }

        if (res.length() == n) {
            System.out.println(res);
            v = true;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            String seq = res + i;
            int len = seq.length();
            boolean check = true;

            for (int j = 1; j <= seq.length() / 2; j++) {
                String left = seq.substring(len - 2 * j, len - j);
                String right = seq.substring(len - j);
                if (left.equals(right)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                back(seq);
            }
        }
    }

}


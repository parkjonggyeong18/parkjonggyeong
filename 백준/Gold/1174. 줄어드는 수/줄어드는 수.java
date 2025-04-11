import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 9; i++) {
            backtrack(i, i);
        }

        Collections.sort(list);

        if (n > list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(n - 1));
        }
    }

    private static void backtrack(long current, int lastDigit) {
        list.add(current);

        for (int nextDigit = 0; nextDigit < lastDigit; nextDigit++) {
            backtrack(current * 10 + nextDigit, nextDigit);
        }
    }
}
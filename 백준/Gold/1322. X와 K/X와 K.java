import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long ans = 0;
        int bit = 0;

        for (int i = 0; bit < 64; i++) {
            if ((x & (1L << i)) == 0) {
                if ((k & (1L << bit)) != 0) {
                    ans |= (1L << i);
                }
                bit++;
            }
        }

        System.out.println(ans);
    }
}

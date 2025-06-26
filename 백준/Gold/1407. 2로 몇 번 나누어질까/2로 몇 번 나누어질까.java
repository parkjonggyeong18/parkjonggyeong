import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long a, b;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        System.out.println(count(b) - count(a - 1));
    }

    private static long count(long n) {
        long cnt = 0;
        long check = 1;

        while (n != 0) {
            if(n % 2 != 0) {
                cnt += ((n / 2) + 1) * check;
            } else {
                cnt += (n/2) * check;
            }
            check *= 2;
            n /= 2;
        }
        return cnt;
    }
}

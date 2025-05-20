import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long gcd = Long.parseLong(st.nextToken());
        long lcm = Long.parseLong(st.nextToken());

        long product = lcm / gcd;
        long a = 0, b = 0;
        long minSum = Long.MAX_VALUE;

        for (long i = 1; i * i <= product; i++) {
            if (product % i == 0) {
                long x = i;
                long y = product / i;
                
                if (gcd(x, y) == 1) {
                    long candidateA = gcd * x;
                    long candidateB = gcd * y;

                    if (candidateA + candidateB < minSum) {
                        minSum = candidateA + candidateB;
                        a = candidateA;
                        b = candidateB;
                    }
                }
            }
        }

        System.out.println(a + " " + b);
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static long a, b, c, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());


        System.out.println( partition(a, b, c));
    }

    private static long partition(long a, long b, long c) {
        if (b == 1) {
            result = a % c;

            return result;
        }
        long temp = partition(a, b / 2, c);

        if (b % 2 == 0) {
            result = (temp * temp) % c;
            return result;
        } else {
            result = ((temp * temp) % c * a) % c;
            return result;
        }

    }
}
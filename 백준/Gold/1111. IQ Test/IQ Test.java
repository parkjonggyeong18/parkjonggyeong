import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, arr[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (n == 1) {
            System.out.println("A");
            return;
        }
        if (n == 2) {
            if (arr[0] == arr[1]) {
                System.out.println(arr[0]);
            } else {
                System.out.println("A");
            }
            return;
        }

        long x = arr[0], y = arr[1], z = arr[2];

        if (x == y) {
            if (y != z) {
                System.out.println("B");
                return;
            }

            for (int i = 3; i < n; i++) {
                if (arr[i] != x) {
                    System.out.println("B");
                    return;
                }
            }

            System.out.println(x);
            return;
        }


        long num = z - y;
        long den = y - x;

        if (num % den != 0) {
            System.out.println("B");
            return;
        }

        long a = num / den;
        long b = y - a * x;


        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] != arr[i] * a + b) {
                System.out.println("B");
                return;
            }
        }

        long next = arr[n - 1] * a + b;
        System.out.println(next);
    }
    
}


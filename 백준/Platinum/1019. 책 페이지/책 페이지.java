import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.*;
import java.util.List;

public class Main {
    static int n, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[10];

        for (int i = 1; i <= n; i *= 10) {
            int high = n / (i * 10);
            int low = n % i;
            int cur = (n / i) % 10;

            for (int j = 0; j < 10; j++) {
                arr[j] += high * i;
              
                if (j < cur) {
                    arr[j] += i;
                } else if (j == cur) {
                    arr[j] += low + 1;
                }
            }
            arr[0] -= i;
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
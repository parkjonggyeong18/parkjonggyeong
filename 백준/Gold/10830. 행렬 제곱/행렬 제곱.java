import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, a[][];
    static long b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());  // 큰 값을 위해 Long.parseLong 사용
        
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] result = pow(a, b);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static int[][] pow(int[][] a, long b) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            result[i][i] = 1; 
        }
        
        while (b > 0) {
            if (b % 2 == 1) {
                result = multiply(result, a);
            }
            a = multiply(a, a);
            b /= 2;
        }
        return result;
    }

    private static int[][] multiply(int[][] a, int[][] b) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] = (int) ((result[i][j] + (long) a[i][k] * b[k][j]) % 1000);
                }
            }
        }
        return result;
    }
}

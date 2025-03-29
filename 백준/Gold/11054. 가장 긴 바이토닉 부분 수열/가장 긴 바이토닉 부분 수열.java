import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[N];
        int[] lds = new int[N];
        
        for (int i = 0; i < N; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            lds[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (A[j] < A[i] && lds[i] < lds[j] + 1) {
                    lds[i] = lds[j] + 1;
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            maxLength = Math.max(maxLength, lis[i] + lds[i] - 1);
        }

        System.out.println(maxLength);
    }
}
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long result = 1;
        int twoCount = 0, fiveCount = 0;

        for (int i = 1; i <= n; i++) {
            int num = i;

            // 2와 5의 개수를 세기
            while (num % 2 == 0) {
                twoCount++;
                num /= 2;
            }
            while (num % 5 == 0) {
                fiveCount++;
                num /= 5;
            }

            // 현재 값을 곱하고 뒤 5자리 유지
            result = (result * num) % 100000;
        }

        // 남은 2와 5의 차이만큼 2를 곱해줌
        int extraTwos = twoCount - fiveCount;
        for (int i = 0; i < extraTwos; i++) {
            result = (result * 2) % 100000;
        }

        System.out.printf("%05d\n", result); // 뒤 5자리를 출력
    }
}
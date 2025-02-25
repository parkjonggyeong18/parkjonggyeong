import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 에라토스테네스의 체로 소수 구하기
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 소수 리스트 생성
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primeList.add(i);
            }
        }

        // 투 포인터로 연속된 소수의 합 계산
        int count = 0, start = 0, end = 0, sum = 0;
        while (true) {
            if (sum >= n) {
                sum -= primeList.get(start++);
            } else if (end == primeList.size()) {
                break;
            } else {
                sum += primeList.get(end++);
            }
            if (sum == n) {
                count++;
            }
        }

        System.out.println(count);
    }
}

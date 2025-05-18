import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // n 입력
        long k = Long.parseLong(st.nextToken()); // k 입력

        long numLen = 1; // 찾고자 하는 숫자의 자리수
        long numCount = 9; // 찾고자 하는 숫자의 자리수별 개수 (1자리 숫자: 9개, 2자리 숫자: 90개, ...)
        while (k > numCount * numLen) { // k가 현재 자리수별 최대 개수를 초과하는 경우
            k -= (numLen * numCount); // k에서 현재 자리수별 최대 개수를 뺌
            numLen++; // 자리수를 증가시킴
            numCount *= 10; // 최대 개수를 업데이트
        }
        k -= 1; // k를 0부터 시작하도록 조정

        long num = (long)Math.pow(10, (numLen - 1)) + (k / numLen); // 찾고자 하는 숫자 계산
        if (num > n) { // 찾고자 하는 숫자가 n보다 큰 경우
            System.out.println(-1); // -1 출력 (해당 숫자는 없음)
        } else {
            System.out.println(String.valueOf(num).charAt((int)(k % numLen))); // 찾은 숫자의 k번째 자리 출력
        }
    }
}
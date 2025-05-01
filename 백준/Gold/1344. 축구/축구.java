import java.io.*;
import java.util.*;

public class Main {
    static final int MAX_GOALS = 18;
    static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double aProb = Integer.parseInt(br.readLine()) / 100.0;
        double bProb = Integer.parseInt(br.readLine()) / 100.0;

        double[] aDP = calculateProbabilities(aProb);
        double[] bDP = calculateProbabilities(bProb);

        double neitherPrime = 0.0;

        for (int i = 0; i <= MAX_GOALS; i++) {
            for (int j = 0; j <= MAX_GOALS; j++) {
                if (!isPrime(i) && !isPrime(j)) {
                    neitherPrime += aDP[i] * bDP[j];
                }
            }
        }

        double result = 1.0 - neitherPrime;
        System.out.printf("%.6f\n", result);
    }

    private static double[] calculateProbabilities(double prob) {
        double[] dp = new double[MAX_GOALS + 1];
        dp[0] = 1.0;

        for (int i = 1; i <= MAX_GOALS; i++) {
            for (int j = i; j > 0; j--) {
                dp[j] = dp[j] * (1 - prob) + dp[j - 1] * prob;
            }
            dp[0] *= (1 - prob);
        }

        return dp;
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
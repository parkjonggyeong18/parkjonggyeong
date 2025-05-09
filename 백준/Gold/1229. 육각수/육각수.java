import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader bf;
	private static StringTokenizer st;
	
	private static int N;
	private static int dp[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		bf=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(bf.readLine());
		dp=new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		int idx=0;
		int diagram=diagramNum(idx);
		for(int i=1;i<=N;i++) {
			int next=diagramNum(idx+1);	// 다음 크기의 육각수 점 개수
			if(i==next) {	// 현재 값이 다음 육각수의 점 개수와 같으면 1을 저장하고 다음으로 넘어감
				dp[i]=1;
				continue;
			}
			if(i>next) idx++;	// 현재 값이 다음 육각수의 점 개수보다 크면, 해당 육각수부터 처음 육각수까지 탐색하며 구하는 값이 최소인 경우를 찾음
			for(int j=idx;j>=0;j--) {
				diagram=diagramNum(j);
				if(dp[diagram]==Integer.MAX_VALUE) continue;
				dp[i]=Math.min(dp[i-diagram]+dp[diagram], dp[i]);
				
			}
		}
		
		System.out.println(dp[N]);
	}

	public static int diagramNum(int n) {
		if(n<=0) return 0;
		return 2*n*n-n;
	}
}

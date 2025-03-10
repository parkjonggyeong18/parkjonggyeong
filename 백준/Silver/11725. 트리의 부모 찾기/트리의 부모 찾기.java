import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static ArrayList<Integer>[] list;
	static int[] p;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		p = new int[n + 1];
		dfs(1, -1);
		for (int i = 2; i <= n; i++) {
			System.out.println(p[i]);
		}
	}

	private static void dfs(int start, int pas) {
		p[start] = pas;
		
		for(int s : list[start]) {
			if(s != pas) {
				dfs(s, start);
			}
		}
	}
}

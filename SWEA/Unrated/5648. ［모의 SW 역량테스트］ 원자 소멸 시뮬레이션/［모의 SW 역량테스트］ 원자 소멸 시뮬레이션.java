import java.util.*;
import java.io.*;

public class Solution {
	static List<Atom> atom;
	static int dx[] = new int[] { 0, 0, -1, 1 };
	static int dy[] = new int[] { 1, -1, 0, 0 };
	static int map[][] = new int[4001][4001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		atom = new ArrayList<>();
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int y = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int dir = Integer.parseInt(st.nextToken());
				int energy = Integer.parseInt(st.nextToken());
				atom.add(new Atom(x,y,dir,energy));
				map[x][y] = energy;
			}

			// 상(y값 증가), 하(y값 감소), 좌(x값 감소) 우(x값 증가)
			int result = solve();
			System.out.println("#"+tc+" "+result);
		}
	}

	static int solve() {
		int sum = 0;
		while (!atom.isEmpty()) {
			for (int i = 0; i < atom.size(); i++) {
				Atom a = atom.get(i);
				map[a.x][a.y] = 0;
				a.x += dx[a.dir];
				a.y += dy[a.dir];
				if (a.x > 4000 || a.x < 0 || a.y > 4000 || a.y < 0) {
					atom.remove(i);
					i--;
					continue;
				}
				map[a.x][a.y] += a.energy;
			}
			for (int i = 0; i <atom.size(); i++) {
				Atom a = atom.get(i);
				if (map[a.x][a.y] != a.energy) {
					sum += map[a.x][a.y];
					map[a.x][a.y] = 0;
					atom.remove(i);
					i--;
				}
			}
		}
		return sum;
	}
	
	static class Atom {
		int x, y;
		int dir;
		int energy;

		public Atom(int x, int y, int dir, int energy) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.energy = energy;
		}
	}
}
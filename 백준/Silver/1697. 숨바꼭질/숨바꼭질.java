import java.io.*;
import java.util.*;

public class Main {
	
	static int N,K;
	static int[] visit = new int[100001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());

		if(N==K) {
			System.out.println(0);
		}else {
			bfs(N);	
		}
		
		br.close();
	}// main()
	
	static void bfs(int num) {
		
		Queue<Integer> qu = new LinkedList<>();
		qu.add(num);
		visit[num]=1;
		
		while(!qu.isEmpty()) {
			int tmp=qu.poll();
			for(int i=0;i<3;i++) {
				int next;
				if(i==0) {
					next=tmp+1;
				}else if(i==1) {
					next=tmp-1;
				}else {
					next=tmp*2;
				}
				
				if(next==K) {
					System.out.println(visit[tmp]);
					return;
				}
				
				if (next >= 0 && next < visit.length && visit[next] == 0) {
                    qu.add(next);
                    visit[next] = visit[tmp] + 1;
                }
			}
		}
	}
	
}
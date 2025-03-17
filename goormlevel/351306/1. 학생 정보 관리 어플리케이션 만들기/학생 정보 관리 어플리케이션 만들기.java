import java.io.*;
import java.util.*;
class Main {
	static int n, cnt;
	static String names[], partial;
	static String f;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		names = new String[n];
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			f = st.nextToken();
			if (f.equals("add")){
				names[i] = st.nextToken();	
			} else {
				cnt = 0;
				partial = st.nextToken();
				for(String name : names){
					if (name != null){
						if(name.startsWith(partial) ){
							cnt++;
						}
					}
				}
				System.out.println(cnt);
			}
		}
	}
}
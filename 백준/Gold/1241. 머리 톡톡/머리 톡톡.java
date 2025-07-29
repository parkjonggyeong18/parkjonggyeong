import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[n+1];
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=1; i<=n; i++) {
			int curr = Integer.valueOf(br.readLine());
			arr[i] = curr;
			if(map.containsKey(curr)) map.put(curr, map.get(curr)+1);
			else map.put(curr, 1);
		}
		
		int[] result = new int[1_000_001];
		for(int key: map.keySet()) {
			int answer = 0;
			
			if(key <= 1) answer = map.get(key) - 1; 
			else {
				for(int i=1; i<=Math.sqrt(key); i++) {
					
					if(key % i == 0) {
						if(map.containsKey(i)) answer += map.get(i);
						if(map.containsKey(key/i)) {
							answer += map.get(key/i);
							if(key/i == key) answer --;
							if(key/i == i) answer -= map.get(i);
						}
					}
				}
			}
			result[key] = answer;
		}
		
		for(int i=1; i<=n; i++) {
			System.out.println(result[arr[i]]);
		}
	}

}
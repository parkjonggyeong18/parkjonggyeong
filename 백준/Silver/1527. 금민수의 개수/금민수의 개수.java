	import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static int a, b, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
 
        calculate(7);
        calculate(4);
 
        System.out.println(cnt);
 
    }
    public static void calculate(long n){
        if(n > b) return;
        if(a <= n) cnt ++;
 
        long x = n * 10 + 7;
        long y = n * 10 + 4;
        calculate(x);
        calculate(y);
 
    }
}
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.valueOf(br.readLine());

        boolean[] visit=new boolean[1000001];
        int[] num=new int[n+1];
        int[] save=new int[1000001];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            int t=Integer.valueOf(st.nextToken());
            visit[t]=true;
            num[i]=t;
        }

        for(int i=1; i<=n; i++){
            int t=num[i];
            for(int j=1; j<=(int)Math.sqrt(t); j++){
                if(t%j!=0){
                    continue;
                }
                if(visit[j]){
                    save[j]++;
                    save[t]--;
                }
                if(j*j!=t && visit[t/j]){
                    save[t/j]++;
                    save[t]--;
                }
            }

        }
        for(int i=1; i<=n; i++){
            bw.write(save[num[i]]+" ");
        }
        bw.flush();

    }
}
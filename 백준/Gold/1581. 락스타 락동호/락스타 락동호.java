import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int FF = Integer.parseInt(st.nextToken());
        int FS = Integer.parseInt(st.nextToken());
        int SF = Integer.parseInt(st.nextToken());
        int SS = Integer.parseInt(st.nextToken());

        if (FF == 0 && FS == 0) {
            if(SF == 0)
                System.out.println(SS);
            else
                System.out.println(SS + 1);
        }else if(FS == 0)
            System.out.println(FF);
        else{
            if(FS <= SF)
                System.out.println(FF + FS + FS + SS);
            else
                System.out.println(FF + SF + SF + SS + 1);
        }
    }
}
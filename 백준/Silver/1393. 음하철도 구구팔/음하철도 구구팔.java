import java.io.*;
import java.util.*;

public class Main {
    static int xs, ys, xe, ye, dx, dy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        xs = Integer.parseInt(st.nextToken());
        ys = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        xe = Integer.parseInt(st.nextToken());
        ye = Integer.parseInt(st.nextToken());
        dx = Integer.parseInt(st.nextToken());
        dy = Integer.parseInt(st.nextToken());

        double numerator = dx * (xs - xe) + dy * (ys - ye);
        double denominator = dx * dx + dy * dy;
        double t =  numerator / denominator;
        t = Math.max(0, t);

        int xt = (int)Math.round(xe + t * dx);
        int yt = (int)Math.round(ye + t * dy);

        System.out.println(xt + " " + yt);
    }
}
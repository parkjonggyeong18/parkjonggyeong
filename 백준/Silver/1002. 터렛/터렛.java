import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            sb.append(findIntersectionPoints(x1, y1, r1, x2, y2, r2)).append("\n");
        }

        System.out.print(sb.toString());
    }

    private static int findIntersectionPoints(int x1, int y1, int r1, int x2, int y2, int r2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance == 0 && r1 == r2) {
            return -1;
        } else if (distance > r1 + r2 || distance < Math.abs(r1 - r2)) {
            return 0;
        } else if (distance == r1 + r2 || distance == Math.abs(r1 - r2)) {
            return 1;
        } else {
            return 2;
        }
    }
}
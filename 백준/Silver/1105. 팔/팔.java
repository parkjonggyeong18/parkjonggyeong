import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String l = st.nextToken();
        String r = st.nextToken();

        int minCount = Integer.MAX_VALUE;

        if (l.length() == r.length()) {
            int count = 0;
            for (int i = 0; i < l.length(); i++) {
                if (l.charAt(i) != r.charAt(i)) {
                    break;
                }
                if (l.charAt(i) == '8') {
                    count++;
                }
            }
            minCount = count;
        } else {
            minCount = 0;
        }

        System.out.println(minCount);
    }
}
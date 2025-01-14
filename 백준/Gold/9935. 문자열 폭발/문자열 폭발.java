import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String n;      // 원본 문자열
    static String bomb;   // 폭탄 문자열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.readLine();      // 입력: 원본 문자열
        bomb = br.readLine();   // 입력: 폭탄 문자열

        String result = removeBombs(n, bomb);

        if (result.isEmpty()) {
            System.out.println("FRULA");
        } else {
            System.out.println(result);
        }
    }

    private static String removeBombs(String n, String bomb) {
        StringBuilder sb = new StringBuilder(); 
        int bombLength = bomb.length();        

        for (char c : n.toCharArray()) {
            sb.append(c); 

          
            if (sb.length() >= bombLength &&
                    sb.substring(sb.length() - bombLength).equals(bomb)) {
               
                sb.delete(sb.length() - bombLength, sb.length());
            }
        }

        return sb.toString(); 
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] card;

    private static int moves(int joker) {
        boolean[] colorUsed = new boolean[M];
        int moves = 0;

        for (int box = 0; box < N; box++) {
            if (box == joker) continue;

            int different = 0, onlyColor = -1;
            for (int c = 0; c < M; c++) {
                if (card[box][c] > 0) {
                    different++;
                    onlyColor = c;
                }
            }

            if (different == 0) continue;
            if (different > 1) {
                moves++;
            } else {
                if (!colorUsed[onlyColor]) {
                    colorUsed[onlyColor] = true;
                } else {
                    moves++;
                }
            }
        }
        return moves;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        card = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                card[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int joker = 0; joker < N; joker++) {
            answer = Math.min(answer, moves(joker));
        }
        System.out.println(answer);
    }
}

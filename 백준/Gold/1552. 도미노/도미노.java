import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static boolean[] visited;
    static int maxScore = Integer.MIN_VALUE;
    static int minScore = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];

        // 도미노 값 입력 및 변환
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                if (Character.isDigit(c)) {
                    board[i][j] = c - '0';
                } else {
                    board[i][j] = -(c - 'A' + 1);
                }
            }
        }

        // N개의 도미노를 선택하는 모든 경우 탐색
        permute(new int[N], 0, new boolean[N]);

        // 결과 출력
        System.out.println(minScore);
        System.out.println(maxScore);
    }

    // 순열 생성 (N개의 도미노 선택)
    static void permute(int[] selected, int depth, boolean[] used) {
        if (depth == N) {
            calculateScore(selected);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                used[i] = true;
                selected[depth] = i;
                permute(selected, depth + 1, used);
                used[i] = false;
            }
        }
    }

    // 점수 계산
    static void calculateScore(int[] selected) {
        // 선택된 도미노의 값 곱 계산
        int product = 1;
        for (int i = 0; i < N; i++) {
            product *= board[i][selected[i]];
        }

        // 사이클 그룹 계산
        int groups = countCycles(selected);

        // 점수 조정
        if (groups % 2 == 0) {
            product *= -1;
        }

        // 최대 및 최소 점수 갱신
        maxScore = Math.max(maxScore, product);
        minScore = Math.min(minScore, product);
    }

    // 사이클 그룹 계산 (그래프 탐색)
    static int countCycles(int[] selected) {
        visited = new boolean[N];
        int groups = 0;

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                groups++;
                dfs(i, selected);
            }
        }

        return groups;
    }

    // DFS를 이용한 사이클 탐색
    static void dfs(int node, int[] selected) {
        if (visited[node]) return;
        visited[node] = true;

        int next = selected[node];
        dfs(next, selected);
    }
}
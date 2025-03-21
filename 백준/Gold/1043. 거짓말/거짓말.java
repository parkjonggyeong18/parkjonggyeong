import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m, parent[];
    static boolean[] knowsTruth;
    static ArrayList<Integer>[] parties;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 사람 수 n, 파티 수 m
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        knowsTruth = new boolean[n + 1];
        parties = new ArrayList[m];

        for (int i = 1; i <= n; i++) parent[i] = i;

        // 진실을 아는 사람 입력
        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        ArrayList<Integer> truthPeople = new ArrayList<>();
        for (int i = 0; i < truthCount; i++) {
            int person = Integer.parseInt(st.nextToken());
            knowsTruth[person] = true;
            truthPeople.add(person);
        }

        // 파티 입력 및 유니온 파인드 적용
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int partyCount = Integer.parseInt(st.nextToken());
            parties[i] = new ArrayList<>();
            int firstPerson = Integer.parseInt(st.nextToken());
            parties[i].add(firstPerson);

            for (int j = 1; j < partyCount; j++) {
                int nextPerson = Integer.parseInt(st.nextToken());
                parties[i].add(nextPerson);
                union(firstPerson, nextPerson);
            }
        }

        // 진실을 아는 그룹 전체 파악
        for (int i = 1; i <= n; i++) {
            if (knowsTruth[i]) {
                int root = find(i);
                knowsTruth[root] = true;
            }
        }

        // 파티마다 과장 가능 여부 판단
        int answer = 0;
        for (int i = 0; i < m; i++) {
            boolean canLie = true;
            for (int person : parties[i]) {
                if (knowsTruth[find(person)]) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) answer++;
        }

        System.out.println(answer);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
}

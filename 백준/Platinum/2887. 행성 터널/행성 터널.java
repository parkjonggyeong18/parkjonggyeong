import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Tunnel implements Comparable<Tunnel> {
        int start, end, cost;

        public Tunnel(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
        @Override
        public int compareTo(Tunnel o) {
            return cost - o.cost;
        }
    }

    private static int[] parents;
    private static final PriorityQueue<Tunnel> allTunnel = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] planets = new int[n][4]; //x,y,z
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            planets[i][3] = i;//idx
            planets[i][0] = Integer.parseInt(st.nextToken());
            planets[i][1] = Integer.parseInt(st.nextToken());
            planets[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 3; i++) {
            int now = i;
            Arrays.sort(planets, Comparator.comparingInt(o -> o[now]));
            for (int j = 0; j < n - 1; j++) {
                int min = Math.abs(planets[j][i] - planets[j + 1][i]);
                allTunnel.add(new Tunnel(planets[j][3], planets[j + 1][3], min));
            }
        }


        long minDistance = 0;
        while (!allTunnel.isEmpty()) {
            Tunnel poll = allTunnel.poll();
            int aParent = findParent(poll.start);
            int bParent = findParent(poll.end);
            if (aParent == bParent) continue;
            minDistance += poll.cost;
            unionParents(aParent, bParent);
        }
        System.out.println(minDistance);

    }

    static int findParent(int x) {
        if (parents[x] == x) return x;
        return parents[x] = findParent(parents[x]);
    }

    static void unionParents(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parents[b] = a;
        else parents[a] = b;
    }
}

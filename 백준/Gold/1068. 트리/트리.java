import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static List<Integer>[] tree;
    static int delete;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree  = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        int root = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
            } else {
                tree[parent].add(i);
            }
        }
        delete = Integer.parseInt(br.readLine());

        if (delete == root) {
            System.out.println(0);
        } else {
            count(root);
            System.out.println(cnt);
        }
    }

    private static void count(int root) {
        if (root == delete) {
            return;
        }
        if (tree[root].isEmpty() || (tree[root].size() == 1) ){
            cnt++;
            return;
        }
        for (int child : tree[root]) {
            if (child != delete) {
                count(child);
            }
        }
    }

}
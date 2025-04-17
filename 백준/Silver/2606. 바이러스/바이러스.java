import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt(); 
        int m = input.nextInt(); 

        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = input.nextInt();
            int b = input.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a); 
        }

        dfs(1); 

        System.out.println(count); 
    }

    public static void dfs(int node) {
        visited[node] = true;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                count++;
                dfs(next);
            }
        }
    }
}

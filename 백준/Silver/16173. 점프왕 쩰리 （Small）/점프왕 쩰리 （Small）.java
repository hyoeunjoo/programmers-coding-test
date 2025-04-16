import java.util.Scanner;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int N;
    static boolean isPossible = false;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = input.nextInt();
            }
        }

        dfs(0, 0);

        if (isPossible) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    static void dfs(int x, int y) {
        if (x >= N || y >= N || visited[x][y]) return;

        if (board[x][y] == -1) {
            isPossible = true;
            return;
        }

        visited[x][y] = true;
        int jump = board[x][y];

        dfs(x, y + jump);

        dfs(x + jump, y);
    }
}

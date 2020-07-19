import java.io.*;
import java.util.StringTokenizer;

public class MinimizingCoins {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task {
        static int f(int[] coins, int x) {
            int n = coins.length;
            int MAX = Integer.MAX_VALUE;

            int[][] dp = new int[n + 1][x + 1];

            for (int j = 1; j < x + 1; j++) {
                dp[0][j] = MAX;
            }
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < x + 1; j++) {
                    if (coins[i - 1] == j) {
                        dp[i][j] = 1;
                    } else if (coins[i - 1] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (dp[i][j - coins[i - 1]] < MAX) {
                        dp[i][j] = Math.min(
                                dp[i - 1][j],
                                1 + dp[i][j - coins[i - 1]]
                        );
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[n][x];
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int x = in.nextInt();

            int[] coins = new int[n];
            for (int i = 0; i < n; i++) {
                coins[i] = in.nextInt();
            }

            int result = f(coins, x);

            if (result == Integer.MAX_VALUE) {
                out.println(-1);
            } else {
                out.println(result);
            }
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

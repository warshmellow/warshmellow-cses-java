import java.io.*;
import java.util.*;

public class DiceCombinations {
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
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long n = in.nextLong();
            out.println(f(n));
        }

        long f(long n) {
            long MOD = 1000000000 + 7;

            Map<Long, Long> mp = new HashMap<>();
            mp.put(0L, 0L);
            mp.put(1L, 1L);
            mp.put(2L, 2L);
            mp.put(3L, 4L);
            mp.put(4L, 8L);
            mp.put(5L, 16L);
            mp.put(6L, 32L);

            if (0 <= n && n <= 6) {
                return mp.get(n);
            }

            long currSum = 0;
            for (long i = 1; i <= 6; i++) {
                currSum += mp.get(i);
            }

            if (n == 7) {
                return currSum;
            }

            mp.put(7L, currSum);

            // n >= 8
            for (long i = 8; i <= n; i++) {
                // process i; eventually we'll do n and return
                // get sum of mp[n - 1] to mp[n - 6]
                // store mp[n] = this sum
                // currSum is answer for 7
                // update for 8 by subtracting mp[1] = mp[8 - 7]
                long lower = i - 7;
                currSum = (currSum % MOD + currSum % MOD - mp.get(lower)) % MOD;
                mp.put(i, currSum);
            }

            long result = mp.get(n);
            if (result < 0) {
                return result + MOD;
            } else {
                return result;
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

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}

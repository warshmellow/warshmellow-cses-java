import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Permutations {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static Optional<List<Long>> f(long n) {
        if (n == 2 || n == 3) {
            return Optional.empty();
        } else if (n == 4) {
            return Optional.of(List.of(2L, 4L, 1L, 3L));
        }

        List<Long> odds = new ArrayList<>();
        List<Long> evens = new ArrayList<>();

        for (long i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                evens.add(i);
            } else {
                odds.add(i);
            }
        }

        odds.addAll(evens);

        return Optional.of(odds);
    }

    public static void main(String[] args) {
        FastReader input = new FastReader();
        long n = input.nextLong();

        Optional<List<Long>> result = f(n);

        result.ifPresentOrElse(
                v -> System.out.println(
                        v.stream().map(Object::toString).collect(Collectors.joining(" "))
                ),
                () -> System.out.println("NO SOLUTION\n")
                );
    }
}

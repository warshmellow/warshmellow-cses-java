import java.io.*;
import java.util.*;

public class CreatingStrings1 {
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
        static List<String> f(String s) {
            int n = s.length();

            if (n == 0) {
                return List.of();
            } else if (n == 1) {
                return List.of(s);
            }

            List<String> prev = f(s.substring(1));

            Set<String> resultSet = new HashSet<>();

            for (String partial : prev) {
                String curr = Character.toString(s.charAt(0));
                for (int i = 0; i < n; i++) {
                    String candidate = partial.substring(0, i) + curr + partial.substring(i, n - 1);
                    resultSet.add(candidate);
                }
            }

            return new ArrayList<>(resultSet);
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String s = in.nextLine();
            List<String> result = f(s);
            Collections.sort(result);

            out.println(result.size());
            for (String value : result) {
                out.println(value);
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

        String nextLine() {
            String str = "";
            try {
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

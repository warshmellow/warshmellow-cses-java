import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class PalindromeReorder {
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
        static Map<String, Integer> getCounts(String s) {
            Map<String, Integer> result = new HashMap<>();
            for (String ch : s.split("")) {
                if (result.containsKey(ch)) {
                    result.put(ch, result.get(ch) + 1);
                } else {
                    result.put(ch, 1);
                }
            }
            return result;
        }

        static Optional<String> f(String s) {
            Map<String, Integer> mp = getCounts(s);

            List<String> oddStrings = mp.keySet().stream().filter(x -> mp.get(x) % 2 != 0).collect(toList());

            if (oddStrings.size() > 1) {
                return Optional.empty();
            }

            Deque<String> resultList = new ArrayDeque<>();
            if (oddStrings.size() == 1) {
                String oddString = oddStrings.get(0);
                int cnt = mp.get(oddString);
                for (int i = 0; i < cnt; i++) {
                    resultList.addLast(oddString);
                }
            }

            for (String ch : mp.keySet()) {
                if (oddStrings.contains(ch)) {
                    continue;
                }

                int cnt = mp.get(ch);
                int half = cnt / 2;

                for (int i = 0; i < half; i++) {
                    resultList.addFirst(ch);
                    resultList.addLast(ch);
                }
            }

            return Optional.of(String.join("", resultList));
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String s = in.nextLine();

            f(s).ifPresentOrElse(out::println, () -> out.println("NO SOLUTION"));
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Repetitions {
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

    private static Integer f(String s) {
        int i = 0;
        int maxLen = 1;
        int currLen = 1;

        for (int j = 1; j < s.length(); j++) {
            if (s.charAt(i) == s.charAt(j)) {
                currLen++;
            } else {
                maxLen = Math.max(maxLen, currLen);
                i = j;
                currLen = 1;
            }
        }
        maxLen = Math.max(maxLen, currLen);
        return maxLen;
    }

    public static void main(String[] args) {
        FastReader input = new FastReader();
        String s = input.next();
        System.out.println(f(s));
    }
}

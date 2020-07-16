import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DistinctNumbers {
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

    static int f(List<Integer> nums) {
        Set<Integer> s = new HashSet<>(nums);
        return s.size();
    }

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int n = input.nextInt();

        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = input.nextInt();
            nums.add(s);
        }

        System.out.println(f(nums));
    }
}

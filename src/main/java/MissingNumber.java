import java.io.*;
import java.util.*;

public class MissingNumber {
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

    private static Integer f(List<Integer> nums) {
        Collections.sort(nums);
        for (int i = 0; i < nums.size(); i++) {
            int j = i + 1;
            if (j != nums.get(i)) {
                return j;
            }
        }
        return nums.size() + 1;
    }

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int n = input.nextInt();

        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int s = input.nextInt();
            nums.add(s);
        }

        System.out.println(f(nums));
    }
}
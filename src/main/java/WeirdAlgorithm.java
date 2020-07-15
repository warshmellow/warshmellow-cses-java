import java.util.*;

public class WeirdAlgorithm {
    static List<Long> f(long n) {
        List<Long> result = new ArrayList<>();
        while (true) {
            result.add(n);
            if (n == 1) {
                break;
            } else if (n % 2 == 0)
                n = n / 2;
            else {
                n = n * 3 + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextInt();
        List<Long> result = f(n);
        for (Long i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
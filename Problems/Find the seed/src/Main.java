import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int min = Integer.MAX_VALUE;
        int minSeed = 0;
        for (int i = a; i <= b; i++) {
            Random random = new Random(i);
            int max = 0;
            for (int j = 0; j < n; j++) {
                int x = random.nextInt(k);
                max = Math.max(max, x);
            }
            if (max < min) {
                min = max;
                minSeed = i;
            }
        }
        System.out.println(minSeed);
        System.out.println(min);
    }
}

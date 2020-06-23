import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger a = new BigInteger(scanner.next());
        BigInteger b = new BigInteger(scanner.next());
        BigInteger c = new BigInteger(scanner.next());
        BigInteger d = new BigInteger(scanner.next());

        a = a.negate();
        a = a.multiply(b);
        a = a.add(c);
        a = a.subtract(d);
        System.out.println(a);
    }
}

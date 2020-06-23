import java.math.BigInteger;
import java.util.Scanner;

class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {
        if (n == 0) {
            return BigInteger.ONE;
        }

        BigInteger result = new BigInteger(String.valueOf(n));
        n -= 2;
        while (n > 0) {
            result = result.multiply(new BigInteger(String.valueOf(n)));
            n -= 2;
        }
        return result;
    }
}
package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sourceRadix = 0;
        if (scanner.hasNextInt()) {
            sourceRadix = scanner.nextInt();
        } else {
            System.out.println("error");
            return;
        }
        if (sourceRadix < 1 || sourceRadix > 36) {
            System.out.println("error");
            return;
        }

        String sourceNumber = scanner.next();

        int targetRadix = 0;
        if (scanner.hasNextInt()) {
            targetRadix = scanner.nextInt();
        } else {
            System.out.println("error");
            return;
        }
        if (targetRadix < 1 || targetRadix > 36) {
            System.out.println("error");
            return;
        }

        String[] parts = sourceNumber.split("\\.");
        String sourceNumberInteger = parts[0];
        String sourceNumberFractional = "";
        if (parts.length == 2) {
            sourceNumberFractional = parts[1];
        }

        int integerDecimal;
        double fractionalDecimal = 0.0;

        if (sourceRadix == 1) {
            integerDecimal = sourceNumberInteger.length();
        } else {
            integerDecimal = Integer.parseInt(sourceNumberInteger, sourceRadix);
            for (int i = 0; i < sourceNumberFractional.length(); i++) {
                char c = sourceNumberFractional.charAt(i);
                if (Character.isDigit(c)) {
                    fractionalDecimal += Double.parseDouble(String.valueOf(c)) / Math.pow(sourceRadix, i + 1);
                } else {
                    fractionalDecimal += (double) ((int) c - 87) / Math.pow(sourceRadix, i + 1);
                }
            }
        }

        String targetNumberInteger;
        StringBuilder targetNumberFractional = new StringBuilder();

        if (targetRadix == 1) {
            targetNumberInteger = "1".repeat(integerDecimal);
        } else {
            targetNumberInteger = Long.toString(integerDecimal, targetRadix);
            if (fractionalDecimal != 0) {
                for (int i = 0; i < 5; i++) {
                    double temp = fractionalDecimal * targetRadix;
                    int tempInteger = (int) temp;
                    if (tempInteger > 9) {
                        targetNumberFractional.append((char) (tempInteger + 87));
                    } else {
                        targetNumberFractional.append(tempInteger);
                    }
                    fractionalDecimal = fractionalDecimal * targetRadix - tempInteger;
                }
            }

        }

        System.out.print(targetNumberInteger);
        if (targetNumberFractional.length() > 0) {
            System.out.println("." + targetNumberFractional);
        }

    }
}

package org.ymg.algo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> inputs =  readUserInput();
        System.out.println(String.join("\n", validateIfNumbersAreArmstrongNumber(inputs)));
    }

    public static List<String> validateIfNumbersAreArmstrongNumber(List<Integer> numbers) {
        List<String> validationMessages = new ArrayList<>(numbers.size());
        for (int n : numbers) {
            int sum = 0;
            int currentNumber = n;
            for (int digit = n % 10; n != 0; n /= 10, digit = n % 10) {
                sum += (digit * digit * digit);
                // System.out.println("n: " + n + " digit: " + digit + " sum: " + sum);
            }

            // System.out.println("Number: " + n + " Sum: " + sum);
            if (sum == currentNumber) {
                validationMessages.add("Number is an Armstrong number.");
            } else {
                validationMessages.add("Number is NOT an Armstrong number.");
            }
        }
        return validationMessages;
    }

    public static List<Integer> readUserInput() {
        List<Integer> readValues = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            readValues = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                readValues.add(scanner.nextInt());
            }


        } catch (InputMismatchException ime) {
            System.out.println(ime.getMessage());
        }

        return readValues;
    }
}

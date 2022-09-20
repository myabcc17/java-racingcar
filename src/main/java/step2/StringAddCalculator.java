package step2;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        CalculatorString calculatorString = new CalculatorString(text);

        if (calculatorString.empty()) {
            return 0;
        }

        if (calculatorString.numeral()) {
            return parseOne(calculatorString.text());
        }

        int[] numbers = split(calculatorString.text(), calculatorString.delimiter());

        return sum(numbers);
    }

    public static int[] split(String text, String delimiter) {
        String[] stringNumbers = text.split(delimiter);
        int[] numbers = new int[stringNumbers.length];

        for (int i = 0; i < stringNumbers.length; ++i) {
            int num = Integer.parseInt(stringNumbers[i]);
            validateNumber(num);
            numbers[i] = num;
        }

        return numbers;
    }

    public static int sum(int[] numbers) {
        int sum = 0;

        for (int i = 0; i < numbers.length; ++i) {
            sum += numbers[i];
        }

        return sum;
    }

    public static int parseOne(String text) {
        int num = Integer.parseInt(text);
        validateNumber(num);
        return num;
    }

    private static void validateNumber(int num) {
        if (num < 0) {
            throw new RuntimeException("Negative number can't calculated.");
        }
    }
}

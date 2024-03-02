# Simple-Calculator
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        float valueOne, valueTwo, answer;
        char operator;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter calculation:");
        String input = scanner.nextLine();

        // Splitting the input string by whitespace
        String[] tokens = input.split("\\s+");

        // Checking if the input has three parts: valueOne, operator, valueTwo
        if (tokens.length != 3) {
            System.out.println("Invalid input format");
            return;
        }

        try {
            valueOne = Float.parseFloat(tokens[0]);
            operator = tokens[1].charAt(0);
            valueTwo = Float.parseFloat(tokens[2]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input format");
            return;
        }

        switch (operator) {
            case '/':
                if (valueTwo != 0)
                    answer = valueOne / valueTwo;
                else {
                    System.out.println("Error: Division by zero!");
                    return;
                }
                break;
            case '*':
                answer = valueOne * valueTwo;
                break;
            case '+':
                answer = valueOne + valueTwo;
                break;
            case '-':
                answer = valueOne - valueTwo;
                break;
            case '^':
                answer = (float) Math.pow(valueOne, valueTwo);
                break;
            case ' ':
                answer = (float) Math.sqrt(valueTwo);
                break;
            default:
                System.out.println("Invalid operator");
                return;
        }

        System.out.printf("%.9f %c %.9f = %.6f%n", valueOne, operator, valueTwo, answer);
    }
}

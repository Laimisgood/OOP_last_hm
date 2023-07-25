import java.util.logging.Level;
import java.util.logging.LogManager;

public class Main {
    public static void main(String[] args) {
        // Пример использования калькулятора

        // Настройка логирования
        ComplexCalculator calculator = new ComplexCalculator();
        try {
            calculator.setLogger("logs/calculator.log", Level.INFO);

            String num1 = "2+3i";
            String num2 = "4+5i";

            char operation = '+';
            ComplexNumber resultAddition = calculator.calculateFromString(num1, num2, operation);
            System.out.println("Addition: " + resultAddition);

            operation = '*';
            ComplexNumber resultMultiplication = calculator.calculateFromString(num1, num2, operation);
            System.out.println("Multiplication: " + resultMultiplication);

            operation = '/';
            try {
                ComplexNumber resultDivision = calculator.calculateFromString(num1, num2, operation);
                System.out.println("Division: " + resultDivision);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } finally {
            // Закрыть файл лога после использования
            LogManager.getLogManager().reset();
        }
    }
}

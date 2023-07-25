import java.io.IOException;
import java.util.logging.*;

public class ComplexCalculator {
    private Logger logger;

    public ComplexCalculator() {
        logger = Logger.getLogger(ComplexCalculator.class.getName());
        logger.setLevel(Level.INFO);
    }

    public void setLogger(String logFile, Level level) {
        try {
            FileHandler fileHandler = new FileHandler(logFile);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
            logger.setLevel(level);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ComplexNumber calculate(ComplexNumber num1, ComplexNumber num2, char operation) {
        OperationStrategy strategy = OperationStrategyFactory.createStrategy(operation);
        ComplexNumber result = strategy.calculate(num1, num2);
        logger.info("Operation: " + strategy.getClass().getSimpleName() + ", Result: " + result);
        return result;
    }

    public ComplexNumber calculateFromString(String num1, String num2, char operation) {
        ComplexNumber complexNum1 = ComplexNumber.fromString(num1);
        ComplexNumber complexNum2 = ComplexNumber.fromString(num2);
        return calculate(complexNum1, complexNum2, operation);
    }
}

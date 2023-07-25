public class OperationStrategyFactory {
    public static OperationStrategy createStrategy(char operation) {
        switch (operation) {
            case '+':
                return new AdditionStrategy();
            case '*':
                return new MultiplicationStrategy();
            case '/':
                return new DivisionStrategy();
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}

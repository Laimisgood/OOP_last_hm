public class DivisionStrategy implements OperationStrategy {
    @Override
    public ComplexNumber calculate(ComplexNumber num1, ComplexNumber num2) {
        return num1.divide(num2);
    }
}

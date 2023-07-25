public class MultiplicationStrategy implements OperationStrategy {
    @Override
    public ComplexNumber calculate(ComplexNumber num1, ComplexNumber num2) {
        return num1.multiply(num2);
    }
}

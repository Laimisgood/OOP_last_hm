public class AdditionStrategy implements OperationStrategy {
    @Override
    public ComplexNumber calculate(ComplexNumber num1, ComplexNumber num2) {
        return num1.add(num2);
    }
}

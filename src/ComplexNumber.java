import java.util.Objects;

public class ComplexNumber {
    private double real;
    private double imag;

    public ComplexNumber(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    // Геттеры для получения действительной и мнимой частей
    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    // Операция сложения
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(real + other.real, imag + other.imag);
    }

    // Операция умножения
    public ComplexNumber multiply(ComplexNumber other) {
        double realResult = real * other.real - imag * other.imag;
        double imagResult = real * other.imag + imag * other.real;
        return new ComplexNumber(realResult, imagResult);
    }

    // Операция деления
    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imag * other.imag;
        if (denominator == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        double realResult = (real * other.real + imag * other.imag) / denominator;
        double imagResult = (imag * other.real - real * other.imag) / denominator;
        return new ComplexNumber(realResult, imagResult);
    }

    @Override
    public String toString() {
        return real + " + " + imag + "i";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber other = (ComplexNumber) o;
        return Double.compare(other.real, real) == 0 && Double.compare(other.imag, imag) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imag);
    }

    public static ComplexNumber fromString(String str) {
        String[] parts = str.trim().split("\\s*[+]\\s*");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid complex number format: " + str);
        }
        try {
            double real = Double.parseDouble(parts[0]);
            double imag = Double.parseDouble(parts[1].replace("i", ""));
            return new ComplexNumber(real, imag);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid complex number format: " + str, e);
        }
    }
}

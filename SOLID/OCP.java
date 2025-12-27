import java.util.*;
// Open Close Principle
public class OCP {

    public static void main(String[] args) {

        double amount = 1000;

        // Choose discount type (EXTENSION POINT)
        DiscountStrategy strategy = new StudentDiscount();
        // DiscountStrategy strategy = new SeniorDiscount();
        // DiscountStrategy strategy = new EmployeeDiscount();

        // Calculator (CLOSED for modification)
        DiscountCalculator calculator = new DiscountCalculator();

        double discount = calculator.calculate(strategy, amount);

        System.out.println("Discount Applied: " + discount);
        System.out.println("Final Amount: " + (amount - discount));
    }
}

// 1️⃣ Strategy Interface
interface DiscountStrategy {
    double applyDiscount(double amount);
}
//2️⃣ Concrete Implementations
class StudentDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.10;
    }
}

class SeniorDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.20;
    }
}

class EmployeeDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.30;
    }
}

// 3️⃣ Calculator (Closed for modification)
class DiscountCalculator {
    double calculate(DiscountStrategy strategy, double amount) {
        return strategy.applyDiscount(amount);
    }
}


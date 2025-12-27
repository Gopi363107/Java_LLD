public class PaymentSystem {
    public static void main(String[] args) {
        Payment pay1 = new CreditCardPayment();
        pay1.processPayment();

        Payment pay2 = new UPIPayment();
        pay2.processPayment();

        Payment pay3 = new CashPayment();
        pay3.processPayment();
    }
}
/*
    🟡 Medium-Level LSP Question for YOU:

    System: Payment System

    Interface: PaymentMethod

    Methods: pay()

    Implementations:

    CreditCardPayment

    UPIPayment

    CashPayment

    Think:

    Does cash always support refund?

    Should refund be in same interface?

    👉 Try design without breaking LSP
*/

interface Payment{
    void processPayment();
}

class CreditCardPayment implements Payment{
    @Override
    public void processPayment(){
        System.out.println("Payement processed via CreditCard.");
    }
}

class UPIPayment implements Payment{
    @Override
    public void processPayment(){
        System.out.println("Payment processed via UPI.");
    }
}

class CashPayment implements Payment{
    @Override
    public void processPayment(){
        System.out.println("Payment processed via Cash.");
    }
}

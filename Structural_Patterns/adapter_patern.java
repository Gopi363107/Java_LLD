//main class 
public class adapter_patern {
    public static void main(String[] args) {
        
        PaymentProcessor payAmount = new PaymentAdapter(new PaymentGateway());
        payAmount.pay(98700.0);
        
    }
}

// client requirements now
interface PaymentProcessor{
    void pay(double amount);
}

// legacy code
class PaymentGateway{
    void makePayment(double amount){
        System.out.println("the payment is processing "+ amount);
    }
}

// adapter class
class PaymentAdapter implements PaymentProcessor{
    private PaymentGateway stripe;

    PaymentAdapter(PaymentGateway stripe){
        this.stripe = stripe;
    }

    public void pay(double amount){
        stripe.makePayment(amount);
    }
}




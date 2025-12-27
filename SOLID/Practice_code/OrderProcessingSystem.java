/* SRP
🟡 Medium Level (Interview Standard)

System: Order Processing System

👉 Requirements:

Create an order with items and price
Calculate total amount
Generate invoice
Send order confirmation email
Save order to database

❓ Task:
Design classes following SRP:

No class should have more than one responsibility
Write clean Java code
Include a Main class

📌 Interview Expectation:
They want to see separation of concerns, not perfect DB/email code. 
*/
/*
🧱 Identify Responsibilities (This is the most important step)
1️⃣ Order Data Responsibility

Order ID
Customer details
List of items
Quantity
Price

👉 Pure data holder + minimal behavior

2️⃣ Price Calculation Responsibility

Calculate total
Apply tax
Apply discount (optional)
👉 Business rules change often → separate class

3️⃣ Invoice Generation Responsibility

Format invoice
Print / PDF / text
👉 Presentation logic → separate

4️⃣ Payment Responsibility

Card / UPI / Cash
Payment success / failure
👉 Payment logic changes frequently

5️⃣ Notification Responsibility

Email / SMS / WhatsApp
👉 Independent responsibility

6️⃣ Persistence Responsibility

Save order to DB
Fetch order
👉 Storage layer should not affect business logic
*/
import java.util.*;

public class OrderProcessingSystem {
    public static void main(String[] args) {

        Order order = new Order();

        order.addItem(new OrderItem("Laptop", 50000, 1));
        order.addItem(new OrderItem("Mouse", 500, 2));


        OrderService service = new OrderService();
        service.placeOrder(order);
    
    }
}

class OrderItem{
    private String itemName;
    private double itemPrice;
    private int quantity;

    OrderItem(String itemName,double itemPrice,int quantity){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }

    double getTotalPrice(){
        return itemPrice * quantity;
    }

    String getName(){
        return itemName;
    }

}
class Order{
    private List<OrderItem> items = new ArrayList<>();

    void addItem(OrderItem item){
        items.add(item);
    }

    List<OrderItem> getItems(){
        return items;
    }

}

class PriceCalculator{
    double calculateTotalPrice(Order order){
        double totalAmount = 0;

        for(OrderItem item : order.getItems()){
            totalAmount += item.getTotalPrice();

        }
        return totalAmount;
    }
}

class InvoiceGenerator{ 
    void generateInvoice(Order order , double totalAmount){ 
        System.out.println("|___________________________________________________________________________|"); 
        System.out.println("|                            INVOICE Walmart Store                          |");
        System.out.println("|___________________________________________________________________________|"); 
        for(OrderItem item :order.getItems()){ System.out.println(item.getName()); } 
        System.out.println("Total Amount : "+ totalAmount); 
        System.out.println("|___________________________________________________________________________|");
    } 
}
class PaymentProcessor{
    void processPayment(double amount){
        System.out.println("Payment of " + amount + "successfully processed");
    }
}

class NotificationService{
    void sendNotification(){
        System.out.println("Order placed confirmation sent to customer.");
    }

}

class OrderRepository{
    void save(Order order){
        System.out.println("Order saved to database.");
    }
}

class OrderService{
    private PriceCalculator priceCalculator = new PriceCalculator();
    private InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
    private PaymentProcessor paymentProcessor = new PaymentProcessor();
    private NotificationService notificationService = new NotificationService();
    private OrderRepository orderRepository = new OrderRepository();

    void placeOrder(Order order) {

        double total = priceCalculator.calculateTotalPrice(order);

        paymentProcessor.processPayment(total);

        invoiceGenerator.generateInvoice(order, total);

        notificationService.sendNotification();

        orderRepository.save(order);

    }

}
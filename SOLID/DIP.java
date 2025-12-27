import java.util.*;
// DIP (Dependency Inversion Principle)

// DIP Example: Order processing system
public class DIP{

    public static void main(String[] args) {

        // 🔹 STEP 1: Create low-level object
        // You can choose ANY implementation
        Database mysqlDb = new MySQLDatabase();

        // 🔹 STEP 2: Inject dependency into high-level module
        OrderService orderService1 = new OrderService(mysqlDb);

        // 🔹 STEP 3: Use business logic
        orderService1.placeOrder("iPhone 15");


        System.out.println("--------------------");

        // 🔹 STEP 4: Switch database WITHOUT changing OrderService
        Database mongoDb = new MongoDBDatabase();

        // 🔹 STEP 5: Inject new dependency
        OrderService orderService2 = new OrderService(mongoDb);

        // 🔹 STEP 6: Same business logic, different implementation
        orderService2.placeOrder("MacBook Pro");
    }
}


//ABSTRACTION (Interface)
// High-level modules will depend on this, NOT on concrete DB classes
interface Database {
    void saveOrder(String order);
}

//LOW-LEVEL MODULE 1
// This is one concrete implementation
class MySQLDatabase implements Database {

    @Override
    public void saveOrder(String order) {
        System.out.println("Saving order in MySQL Database: " + order);
    }
}

// LOW-LEVEL MODULE 2
// Another implementation (can be switched easily)
class MongoDBDatabase implements Database {

    @Override
    public void saveOrder(String order) {
        System.out.println("Saving order in MongoDB Database: " + order);
    }
}

//HIGH-LEVEL MODULE
// Business logic (Order processing)
// IMPORTANT: Depends on Database interface, not MySQL or Mongo directly
class OrderService {

    private Database database;

    // Constructor Injection
    // Dependency is passed from outside (DIP magic happens here)
    public OrderService(Database database) {
        this.database = database;
    }

    public void placeOrder(String order) {
        System.out.println("Placing order: " + order);

        // We don't care WHICH database
        // We only care that it follows Database contract
        database.saveOrder(order);
    }
}



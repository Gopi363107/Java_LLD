import java.util.*;

public class Composite {
    public static void main(String[] args) {

        CartItem iphone = new Product("iPhone 15 Pro", 150000.0);
        CartItem ipad = new Product("iPad 16", 250333.0);
        CartItem googlePixel7 = new Product("Google Pixel 7", 42290);
        CartItem book = new Product("The Big Bull", 599);
        CartItem googleGoodies = new Product("Google Gifts", 6999);
        CartItem mac = new Product("MacBook", 312999);
        CartItem asus = new Product("ASUS ROG", 98241);
        CartItem hp = new Product("HP 89 Pro", 85038);
        CartItem macPencil = new Product("Mac Pencil", 85038);
        CartItem earphone = new Product("Apple Earphone", 85038);
        CartItem appleWatch = new Product("Apple Watch 18", 85038);

        // Android combo
        ProductBundle androidCombo = new ProductBundle("Back to School Kit");
        androidCombo.addItem(googlePixel7);
        androidCombo.addItem(googleGoodies);

        // Apple combo
        ProductBundle macCombo = new ProductBundle("Apple Products");
        macCombo.addItem(mac);
        macCombo.addItem(macPencil);
        macCombo.addItem(earphone);
        macCombo.addItem(hp);

        // Special combo
        ProductBundle specialCombo = new ProductBundle("Special Combo");
        specialCombo.addItem(iphone);
        specialCombo.addItem(ipad);
        specialCombo.addItem(macCombo);
        specialCombo.addItem(androidCombo);
        specialCombo.addItem(appleWatch);

        // Cart
        List<CartItem> cart = new ArrayList<>();
        cart.add(book);
        cart.add(asus);
        cart.add(specialCombo);

        // Display cart
        System.out.println("Your Amazon Cart:");
        double total = 0;

        for (CartItem item : cart) {
            item.display("  ");
            total += item.getPrice();
        }

        System.out.println("\nTotal: " + total);
    }
}

// Composite Interface
interface CartItem {
    double getPrice();
    void display(String indent);
}

// Leaf class
class Product implements CartItem {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Product: " + name + " | Price: " + price);
    }
}

// Composite class
class ProductBundle implements CartItem {

    private String bundleName;
    private List<CartItem> items = new ArrayList<>();

    public ProductBundle(String bundleName) {
        this.bundleName = bundleName;
    }

    public void addItem(CartItem item) {
        items.add(item);
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Bundle: " + bundleName);
        for (CartItem item : items) {
            item.display(indent + "  ");
        }
    }
}

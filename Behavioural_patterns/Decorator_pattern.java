// client class
public class Decorator_pattern{
    public static void main(String []args){
        coffee SimpleCoffee = new MilkDecorator(new CreamDecorator(new SimpleCoffee()));

        System.out.println(SimpleCoffee.description());
        System.out.println(SimpleCoffee.cost());

    }
}

//component interface
interface  coffee{
    int cost();
    String description();
}

class SimpleCoffee implements coffee{

    @Override
    public int cost(){
        return 50;
    }

    @Override
    public String description(){
        return "Simple Coffee";
    }
}

//decorator abstract
abstract class CoffeeDecorator implements coffee{

    protected coffee decoratedCoffee;

    public CoffeeDecorator(coffee decoratedCoffee){
        this.decoratedCoffee = decoratedCoffee;
    }
}

//concrete decorator -milk
class MilkDecorator extends CoffeeDecorator{

    public MilkDecorator(coffee decoratedCoffee){
        super(decoratedCoffee);
    }

    public int cost(){
        return decoratedCoffee.cost()+20;
    }

    public String description(){
        return decoratedCoffee.description()+", Milk";
    }
}

// Concrete Decorator – sugar
class SugarDecorator extends CoffeeDecorator{

    public SugarDecorator(coffee decoratedCoffee){
        super(decoratedCoffee);
    
    }

    public int cost(){
        return decoratedCoffee.cost()+ 15;
    }

    public String description(){
        return decoratedCoffee.description()+", Sugar";
    }
}
// Concrete Decorator – Cream
class CreamDecorator extends CoffeeDecorator{

    public CreamDecorator(coffee decoratedCoffee){
        super(decoratedCoffee);
    }

    public int cost(){
        return decoratedCoffee.cost() + 50;
    }

    public String description(){
        return decoratedCoffee.description() +", Cream";
    }
}


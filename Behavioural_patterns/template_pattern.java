// client code
public class template_pattern {
    public static void main(String[] args) {
        Beverage tea = new Tea();
        tea.prepareBeverage();

        System.out.println("____________________________________________");

        Beverage coffee = new Coffee();
        coffee.prepareBeverage();
    }
}

// abstract class
abstract class Beverage{
    
    //template method
    final void prepareBeverage(){
        boilWater();
        addMainIngredients();
        addExtras();
        serve();
    }

    public void boilWater(){
        System.out.println("Water is boiling.");
    }

    protected abstract void addMainIngredients();
    protected abstract void addExtras();

    void serve(){
        System.out.println("Serve the beverages");
    } 

}

// concrete class 
class Tea extends Beverage{

    @Override
    protected void addMainIngredients(){
        System.out.println("Adding tea leaves.");
    }

    @Override
    protected void addExtras(){
        System.out.println("Adding cardamom.");
    }
}

class Coffee extends Beverage{

    @Override
    protected void addMainIngredients(){
        System.out.println("Adding coffee powder.");
    }

    @Override
    protected void addExtras(){
        System.out.println("Adding milk.");
    }
}


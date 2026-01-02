//main code
class abstract_factory {
    public static void main(String []args){
        GUIFactory factory = new WindowsUIFactory();
        Application app = new Application(factory);
        app.render();
    }
}
//Step 1: Abstract Products
interface Button{
    void paint();
}

interface Checkbox{
    void paint();
}

//Step 2:Contcrete products

class WindowsButton implements Button{
    @Override
    public void paint(){
        System.out.println("Windows Button");
    }
}

class MacButton implements Button{
    @Override
    public void paint(){
        System.out.println("Mac Button");
    }
}

class LinuxButton implements Button{
    @Override
    public void paint(){
        System.out.println("Linux Button");
    }
}

class WindowsCheckbox implements Checkbox{
    @Override
    public void paint(){
        System.out.println("Windows Checkbox");
    }
}

class MacCheckbox implements Checkbox{
    @Override
    public void paint(){
        System.out.println("Mac Checkbox");
    }
}

class LinuxCheckbox implements Checkbox{
    @Override
    public void paint(){
        System.out.println("Linux Checkbox");
    }
}

//Step 3: Abstract Factory
interface GUIFactory{
    Button createButton();
    Checkbox createCheckbox();
}

//Step 4: Concrete Factory

class WindowsUIFactory implements GUIFactory{
    @Override
    public Button createButton(){
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox(){
        return new WindowsCheckbox();
    }
}

class MacUIFactory implements GUIFactory{
    @Override
    public Button createButton(){
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox(){
        return new MacCheckbox();
    }
}

class LinuxUIFactory implements GUIFactory{
    @Override
    public Button createButton(){
        return new LinuxButton();
    }

    @Override
    public Checkbox createCheckbox(){
        return new LinuxCheckbox();
    }

}

//Step 5 : Client code
class Application{
    private Button button;
    private Checkbox checkbox;

    Application(GUIFactory factory){
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    
    }

    void render(){
        button.paint();
        checkbox.paint();
    }
}
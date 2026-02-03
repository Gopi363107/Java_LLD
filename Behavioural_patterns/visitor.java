public class visitor {
    
    public static void main(String [] args){
        Shape circle = new Circle(6);
        Shape rectangle = new Rectangle(5,2);

        ShapeVisitor areaVisitor = new AreaCalculator();

        circle.accept(areaVisitor);
        rectangle.accept(areaVisitor);
    }
}

// element   interface
interface Shape{
    void accept(ShapeVisitor visitor);
}

// concrete elements
class Circle implements Shape{
    int radius;

    public Circle(int radius){
        this.radius = radius;
    }

    @Override
    public void accept(ShapeVisitor visitor){
        visitor.visit(this);
    }
}

class Rectangle implements Shape{
    int width;
    int height;

    public Rectangle(int width , int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public void accept(ShapeVisitor visitor){
        visitor.visit(this);
    }
}

// visitor interface
interface ShapeVisitor{
    void visit(Circle circle);
    void visit(Rectangle rectangle);
}

// concrete visitors
class AreaCalculator implements ShapeVisitor{

    @Override
    public void visit(Circle circle){
        double area = Math.PI * circle.radius * circle.radius;
        System.out.println("Area of circle " + area);
    }

    @Override
    public void visit(Rectangle rectangle){
        int area = rectangle.width * rectangle.height;
        System.out.println("Area of rectangle " + area);
    }
}

import java.util.*;
public class observer {
    
    public static void main(String[] args) {
        WeatherStation weatherstation = new WeatherStation();
        weatherstation.registerObserver(new PhoneDisplay());
        weatherstation.registerObserver(new TVDisplay());

        weatherstation.setTemperature(10);
        weatherstation.setTemperature(87);
        weatherstation.setTemperature(22);
    }

}

//  Observer interface

interface Observer{
    void update(int temperature);
}

// Subject interface
interface Subject{
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// concrete subject
class WeatherStation implements Subject{
    private ArrayList<Observer> observers = new ArrayList<>();
    private int temperature;

    public void setTemperature(int temp){
        this.temperature = temp;
        notifyObservers();
    }

    public void registerObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
        observers.remove(o);
    }

    public void notifyObservers(){
        for(Observer o : observers){
            o.update(temperature);
        }
    }
}

// concrete observers
class PhoneDisplay implements Observer{
    public void update(int temperature){
        System.out.println("Phone Display : " + temperature);
    }
}

class TVDisplay implements Observer {
    public void update(int temperature){
        System.out.println("TV Display : " + temperature);
    }
}



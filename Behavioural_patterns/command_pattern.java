// client
public class command_pattern{
    public static void main(String [] args){
        Light light = new Light();
        AC ac = new AC();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        Command acOn = new ACOnCommand(ac);
        Command acOff = new ACOffCommand(ac);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();

        remote.setCommand(acOn);
        remote.pressButton();

        remote.setCommand(acOff);
        remote.pressButton();
    }
}

// command interface
interface Command{
    void execute();
}

// receiver actual worker
class Light{

    void on(){
        System.out.println("Light is on");
    }

    void off(){
        System.out.println("Light is off");
    }
}

class AC{

    void on(){
        System.out.println("AC is on");
    }

    void off(){
        System.out.println("AC is off");
    }
}

// concrete commands
class LightOnCommand implements Command{
    private Light light;

    LightOnCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute(){
        light.on();
    }
}

class LightOffCommand implements Command{
    private Light light;
    
    LightOffCommand(Light light){
        this.light = light;
    }
    @Override
    public void execute(){
        light.off();
    }
}

class ACOnCommand implements Command{
    private AC ac;

    ACOnCommand(AC ac){
        this.ac = ac;
    }
    @Override
    public void execute(){
        ac.on();
    }
}

class ACOffCommand implements Command{
    private AC ac;

    ACOffCommand(AC ac){
        this.ac = ac;
    }
    @Override
    public void execute(){
        ac.off();
    }
}

// Invoker
class RemoteControl{
    private Command command;

    void setCommand(Command command){
        this.command = command;
    }

    void pressButton(){
        command.execute();
    }
}




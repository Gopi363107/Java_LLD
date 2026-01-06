// facade pattern example with interface (advanced design)

// client class
public class facade_pattern1 {
    public static void main(String[] args) {
        computer cf = new ComputerFacade();
        cf.start();
    }
}

// complex subsystems
class CPU{
    void start(){
        System.out.println("Cpu is started..");
    }
}

class Memory{
    void load(){
        System.out.println("Memory is loaded..");
    }
}

class HardDrive{
    void read(){
        System.out.println("Hard drive is reading..");
    }
}
// interface for this class
interface computer{
    void start();
}

// concrete class for this interface facade
class ComputerFacade implements computer{

    private CPU cpu = new CPU();
    private Memory memory = new Memory();
    private HardDrive hardDrive = new HardDrive();

    public void start(){
        cpu.start();
        memory.load();
        hardDrive.read();
        System.out.println("Computer is starting..");
    }
}

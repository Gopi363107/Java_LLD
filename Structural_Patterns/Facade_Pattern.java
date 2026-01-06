// without interface the facade pattern
class Facade_Pattern {
    public static void main(String [] args){
        ComputerFacade cf = new ComputerFacade();
        cf.startComputer();
    }
}

// complex subsystems 
class CPU{
    void start(){
        System.out.println("CPU is started.");
    }
}

class Memory{
    void load(){
        System.out.println("Memoryis  loaded");
    }
}

class HardDrive{
    void read(){
        System.out.println("Hard drive is reading.");
    }
}

// facade class

class ComputerFacade{
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    ComputerFacade(){
        cpu = new CPU();
        memory = new Memory();
        hardDrive = new HardDrive();
    }

    void startComputer(){
        cpu.start();
        memory.load();
        hardDrive.read();
        System.out.println("Compter is starting.");
    }
}
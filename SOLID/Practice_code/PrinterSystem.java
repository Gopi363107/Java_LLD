public class PrinterSystem {
    public static void main(String[] args) {
        
        printable bpPrintable = new BasicPrinter();
        bpPrintable.print();

        printable opPrintable = new OfficePrinter();
        opPrintable.print();

        scanable opScanable = new OfficePrinter();
        opScanable.scan();

        faxable opFaxable = new OfficePrinter();
        opFaxable.fax();
    }
}

/*
🟡 Medium-Level ISP Question

System: Printer System

Operations:

print()
scan()
fax()

Devices:

BasicPrinter (only print)
OfficePrinter (print, scan, fax)

👉 Task:

Identify ISP violation
Design correct interfaces
Write clean Java code
*/

interface printable{
    void print();
}

interface scanable{
    void scan();
}

interface faxable{
    void fax();
}

class BasicPrinter implements printable{
    @Override 
    public void print(){
        System.out.println("the basic printer can take print.");
    }
}

class OfficePrinter implements printable , scanable , faxable{
    @Override
    public void print(){
        System.out.println("the office printer can take print.");
    }

    @Override
    public void scan(){
        System.out.println("the office printer can scan the document.");
    }

    @Override 
    public void fax(){
        System.out.println("the office printer can send and receive fax.");
    }
}
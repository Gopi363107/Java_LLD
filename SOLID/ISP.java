import java.util.*;
// Interface Segregation Principle
public class ISP {
    public static void main(String[] args) {
        HotWater copperHotWater = new CopperBottle();
        copperHotWater.fillHotWater();

        ColdWater copperColdWater = new CopperBottle();
        copperColdWater.fillColdWater();

        HotWater steelHotWater = new SteelBottle();
        steelHotWater.fillHotWater();

        ColdWater steelColdWater = new SteelBottle();
        steelColdWater.fillColdWater();

        ColdWater plasticColdWater = new PlasticBottle();
        plasticColdWater.fillColdWater();


    }
}

interface HotWater{
    void fillHotWater();
}

interface ColdWater{
    void fillColdWater();
}

class SteelBottle implements HotWater,ColdWater{
    @Override
    public void fillHotWater(){
        System.out.println("Steel Water bottle contain hotwater.");
    }

    @Override
    public void fillColdWater(){
        System.out.println("Steel water bottle contains coldwater.");
    }
}

class PlasticBottle implements ColdWater{
    @Override
    public void fillColdWater(){
        System.out.println("Plastic water bottle contains coldwater.");
    }
}

class CopperBottle implements HotWater , ColdWater{
    @Override
    public void fillHotWater(){
        System.out.println("Copper water bottle contains hotwater.");
    }

    @Override
    public void fillColdWater(){
        System.out.println("Copper water bottle contains coldwater.");
    }
}

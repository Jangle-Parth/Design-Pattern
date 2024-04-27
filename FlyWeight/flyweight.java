package FlyWeight;

import java.util.HashMap;

class Bolt {
    String Size;
    int threads;
    String Material;
    boolean qc;

    Bolt(String size) {
        this.Size = size;
    }

    public void showinventory() {
        System.out.println("Size: " + Size + " Threads: " + threads + " Material: " + Material + " QC OK: " + qc);
    }
}

class BoltFactory {
    static HashMap BoltStock = new HashMap();

    static Bolt getBolt(String Size) {
        Bolt bolt = (Bolt) BoltStock.get(Size);
        if (bolt == null) {
            bolt = new Bolt(Size);
            BoltStock.put(Size, bolt);
            System.out.println("Bolt of Size: " + Size + " Added to Inventory");
        }
        return bolt;
    }
}

public class flyweight {
    public static void main(String[] args) {
        Bolt b1 = (Bolt) BoltFactory.getBolt("H1");
        b1.Material = "SS 304";
        b1.qc = true;
        b1.threads = 10;

        Bolt b2 = (Bolt) BoltFactory.getBolt("H2");
        b2.Material = "SS 304";
        b2.qc = true;
        b2.threads = 12;

        Bolt b3 = (Bolt) BoltFactory.getBolt("H3");
        b3.Material = "MS";
        b3.qc = false;
        b3.threads = 14;

        Bolt b4 = (Bolt) BoltFactory.getBolt("H4");
        b4.Material = "SS 316";
        b4.qc = true;
        b4.threads = 16;

        Bolt b5 = (Bolt) BoltFactory.getBolt("H5");
        b5.Material = "SS 304";
        b5.qc = true;
        b5.threads = 10;

        Bolt b6 = (Bolt) BoltFactory.getBolt("H6");
        b6.Material = "MS";
        b6.qc = false;
        b6.threads = 12;
    }
}
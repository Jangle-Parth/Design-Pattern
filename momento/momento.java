package momento;

import java.util.ArrayList;

class Tank {
    String state;

    public Tank(String state) {
        this.state = state;
    }
}

class Labour {
    String state;

    public void setstate(String state) {
        this.state = state;
    }

    public Tank savetoSoftware() {
        return new Tank(state);
    }

    public void getFromSoftware(Tank tank) {
        state = tank.state;
    }

}

class SAP {
    ArrayList<Tank> tankstates = new ArrayList<Tank>();

    public void add(Tank state) {
        tankstates.add(state);
    }

    public Tank get(int index) {
        return tankstates.get(index);
    }
}

public class momento {
    public static void main(String[] args) {
        Labour l = new Labour();
        SAP B1 = new SAP();

        l.setstate("Cutting Done");
        B1.add(l.savetoSoftware());
        l.setstate("Manhole Assembly Done");
        B1.add(l.savetoSoftware());
        System.out.println("Current State: " + l.state);
        l.getFromSoftware(B1.get(0));
        System.out.println("Stating State: " + l.state);
        l.setstate("Airvent Assembly Done");
        B1.add(l.savetoSoftware());
        l.setstate("Shell Assembly Done");
        B1.add(l.savetoSoftware());
        l.setstate("Mounted Manhole and Airvent on Tank");
        B1.add(l.savetoSoftware());
        System.out.println("Whole Progress: ");
        for (int i = 0; i <= B1.tankstates.size() - 1; i++) {
            System.out.println(B1.tankstates.get(i).state);

        }

    }
}
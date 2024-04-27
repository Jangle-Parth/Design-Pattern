class Tank {
    String name;

    Tank(String name) {
        this.name = name;
    }

    public void createtank() {
        System.out.println();
        System.out.println(name);
        System.out.println("Created Tank");
    }

}

abstract class TankFinish {
    Tank tank;

    TankFinish(Tank tank) {
        this.tank = tank;
    }

    public void createtank() {
        tank.createtank();
    }
}

class GlassBead extends TankFinish {

    GlassBead(Tank tank) {
        super(tank);
    }

    public void createtank() {
        tank.createtank();
        System.out.println("Added Glass Bead Finish");
    }

}

class Polish extends TankFinish {

    Polish(Tank tank) {
        super(tank);
    }

    public void createtank() {
        tank.createtank();
        System.out.println("Added Polished Finish");
    }

}

public class decorator {
    public static void main(String[] args) {
        Tank t1 = new Tank("Milk Sotrage Tank");
        GlassBead t2 = new GlassBead(new Tank("Acid Sotrage Tank"));
        Polish t3 = new Polish(new Tank("Beer Sotrage Tank"));
        t1.createtank();
        t2.createtank();
        t3.createtank();
    }
}
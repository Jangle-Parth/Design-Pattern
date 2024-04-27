package Observer;

import java.util.ArrayList;
import java.util.List;

class Customers {
    List<Tank> tanks = new ArrayList<>();
    String workdone;

    public void addObserver(Tank tank) {
        tanks.add(tank);
    }

    public void removeObserver(Tank tank) {
        tanks.remove(tank);
    }

    public void notifyObservers() {
        for (Tank tank : tanks) {
            tank.update(workdone);
        }
    }

    public void setworkdone(String workdone) {
        this.workdone = workdone;
        notifyObservers();
    }
}

class Tank {
    String workdone;

    public void update(String workdone) {
        this.workdone = workdone;
        System.out.println("Work Done: " + workdone);
    }

}

public class observer {
    public static void main(String[] args) {
        Customers tetrapack = new Customers();
        Tank t = new Tank();

        tetrapack.addObserver(t);
        tetrapack.setworkdone("Material Purchased");
    }
}
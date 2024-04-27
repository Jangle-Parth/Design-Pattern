package Factory;

interface Tank {
    void gettype();
}

class ACIDSTORAGE implements Tank {
    public void gettype() {
        System.out.println("This is a Acid Storage Tank");
    }
}

class MILKSTORAGE implements Tank {
    public void gettype() {
        System.out.println("This is a Milk Storage Tank");
    }
}

class TankFactory {
    public Tank createtank(String type) {
        if (type == null) {
            return null;
        } else if (type.equalsIgnoreCase("MILKSTORAGE")) {
            return new MILKSTORAGE();
        } else if (type.equalsIgnoreCase("ACIDSTORAGE")) {
            return new ACIDSTORAGE();
        } else {
            return null;
        }
    }
}

public class tank_factory {
    public static void main(String[] args) {
        TankFactory atpl = new TankFactory();
        Tank VBl = atpl.createtank("ACIDSTORAGE");
        VBl.gettype();
        Tank amul = atpl.createtank("MILKSTORAGE");
        amul.gettype();
    }

}
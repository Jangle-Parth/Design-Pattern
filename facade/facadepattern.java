class Tank {
    public String type;
    public String position;
    public int dia;
    public String client;
    facade atpl = new facade();

    public Tank(String position, String type, int dia, String client) {
        this.type = type;
        this.dia = dia;
        this.client = client;
        this.position = position;
        facade atpl = new facade();
        atpl.createtank(this);
    }

}

class facade {
    public String[] tankparts = new String[5];
    public int[] tankpartscost = new int[5];

    public void createtank(Tank t) {
        setManhole(t);
        setAirvent(t);
        setLiftinghook(t);
        setsprayball(t);
        setShell(t);
        getprice(t);
        getinfo(t);
    }

    public void setManhole(Tank t) {
        int manholedia;
        if (t.position == "Horizontal") {
            manholedia = (t.dia / 100);
            tankparts[0] = "Manhole of position: Top";
            tankpartscost[0] = manholedia * 314;
        } else if (t.position == "Vertical") {
            manholedia = (int) ((t.dia * 2 * 3.14) / 100);
            tankparts[0] = "Manhole of position: Side";
            tankpartscost[0] = manholedia * 314;

        } else {
            if (t.dia > 1000) {
                manholedia = 300;
                tankparts[0] = "Manhole of position: Side";
            } else {
                manholedia = (t.dia / 100);
                tankparts[0] = "Manhole of position: Side";
                tankpartscost[0] = manholedia * 314;
            }

        }

    }

    public void setLiftinghook(Tank t) {
        int nooflifitnghook = (t.dia / 1000) * 2;
        tankpartscost[1] = nooflifitnghook * 300;
        if (nooflifitnghook > 4) {
            tankparts[1] = "Lifting Hook Position: Vertical";
        } else {
            tankparts[1] = "Lifting Hook Position: Horizontal";
        }
    }

    public void setsprayball(Tank t) {
        if (t.type == "Pectin Mixing") {
            tankparts[2] = "Sprayball of Speed: 500 rpm";
            tankpartscost[2] = 1000 * (500 / 100);
        } else if (t.type == "Acid Storage") {
            tankparts[2] = "Sprayball of Speed: 100 rpm";
            tankpartscost[2] = 1000 * (100 / 100);
        } else if (t.type == "Milk Storage") {
            tankparts[2] = "Sprayball of Speed: 200 rpm";
            tankpartscost[2] = 1000 * (200 / 100);
        } else if (t.type == "Butter Storage") {
            tankparts[2] = "Sprayball of Speed: 300 rpm";
            tankpartscost[2] = 1000 * (300 / 100);
        } else {
            tankparts[2] = "Sprayball of Speed: 500rpm";
            tankpartscost[2] = 1000 * (500 / 100);
        }

    }

    public void setAirvent(Tank t) {
        if (t.type.equals("Acid Storage") || t.type.equals("Milk Storage") || t.type.equals("Butter Storage")) {
            tankparts[3] = "No Airvent Required";
            tankpartscost[3] = 0;
        } else if (t.position == "Horizontal" && t.type == "Pectin Mixing") {
            tankparts[3] = "Airvent of Type: Top";
            tankpartscost[3] = (t.dia / 8) * 314;
        } else if (t.position == "Vertical" && t.type == "Pectin Mixing") {
            tankparts[3] = "Airvent of Type: Side";
            tankpartscost[3] = (t.dia / 8) * 314;
        } else {
            tankparts[3] = "Airvent of Type: Top";
            tankpartscost[3] = (t.dia / 8) * 314;
        }

    }

    public void setShell(Tank t) {
        if (t.type.equals("Acid Storage") || t.type.equals("Pectin Minxing")) {
            tankparts[4] = "Tank Shell Material: SS 316";
            tankpartscost[4] = t.dia * 340;
        } else if (t.type.equals("Milk Storage") || t.type.equals("Butter Storage")) {
            tankparts[4] = "Tank Shell Material: SS 304";
            tankpartscost[4] = t.dia * 314;
        }
    }

    public void getprice(Tank t) {
        int price = 0;
        for (int i = 0; i <= tankpartscost.length - 1; i++) {
            price = price + tankpartscost[i];
        }
        System.out.println("Price of Tank is: " + price);
        System.out.println();
    }

    public void getinfo(Tank t) {
        for (int j = 0; j <= tankparts.length - 1; j++) {
            System.out.println(tankparts[j]);
        }
        System.out.println();
    }
}

public class facadepattern {
    public static void main(String args[]) {
        Tank t = new Tank("Horizontal", "Acid Storage", 5000, "Coca-Cola");
        Tank t2 = new Tank("Vertical", "Milk Storage", 2500, "Nestle");
    }
}
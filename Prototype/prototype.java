import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Tank {
    private String Manhole;
    private String Airvent;
    private String Sprayball;

    public void setAirvent(String airvent) {
        Airvent = airvent;
    }

    public void setManhole(String manhole) {
        Manhole = manhole;
    }

    public void setSprayball(String sprayball) {
        Sprayball = sprayball;
    }

    public void showinfo() {
        System.out.println();
        System.out.println("Tank Has a Manhole of Type: " + Manhole);
        System.out.println("Tank Has a Airvent of Type: " + Airvent);
        System.out.println("Tank Has a Sprayball of Type: " + Sprayball);
        System.out.println();
    }

    public String getAirvent() {
        return Airvent;
    }

    public String getManhole() {
        return Manhole;
    }

    public String getSprayball() {
        return Sprayball;
    }

}

class Client implements Cloneable {
    private String clientname;
    private int totaltank;
    List<Tank> tanks = new ArrayList<>();

    Client(String name, int total_tanks) {
        this.clientname = name;
        this.totaltank = total_tanks;
    }

    public void RegisterOrder() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        for (int i = 0; i < totaltank; i++) {
            tanks.add(new Tank());
            System.out.println();
            System.out.println("Enter the Airvent Type for Tank " + (i + 1));
            String pairvent = sc.nextLine();
            System.out.println("Enter the Manhole Type for Tank " + (i + 1));
            String pmanhole = sc.nextLine();
            System.out.println("Enter the SprayBall Type for Tank " + (i + 1));
            String psprayball = sc.nextLine();
            tanks.get(i).setAirvent(pairvent);
            tanks.get(i).setManhole(pmanhole);
            tanks.get(i).setSprayball(psprayball);
        }
    }

    public void showorderinfo() {
        System.out.println();
        System.out.println("Client name: " + clientname);
        System.out.println("Total Tanks: " + totaltank);
        int i = 0;
        for (Tank tank : tanks) {
            tanks.get(i).showinfo();
            i++;
        }
    }

    public Object Shallowclone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Client DeepClone() throws CloneNotSupportedException {
        Client c = new Client(clientname, totaltank);
        int i = 0;
        for (Tank tank : tanks) {
            Tank originalTank = tanks.get(i);
            Tank clonedtank = new Tank();
            clonedtank.setAirvent(originalTank.getAirvent());
            clonedtank.setManhole(originalTank.getManhole());
            clonedtank.setSprayball(originalTank.getSprayball());
            c.tanks.add(clonedtank);
            i++;
        }
        return c;

    }

}

public class prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Client Tetrapack = new Client("Tetrapack", 4);
        Tetrapack.RegisterOrder();
        Tetrapack.showorderinfo();
        Client SPXFlow = Tetrapack.DeepClone();
        Client Amul = (Client) Tetrapack.Shallowclone();
        Tetrapack.tanks.remove(2);
        SPXFlow.showorderinfo();
        Amul.showorderinfo();
    }
}

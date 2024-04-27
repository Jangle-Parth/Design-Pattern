class Tanks {
    String Manhole;
    String airvent;
    String sprayball;
    String leg;
    String Shell;

    public Tanks(String pManhole, String pairvent, String psprayball, String pleg, String pShell) {
        this.Manhole = pManhole;
        this.Shell = pShell;
        this.airvent = pairvent;
        this.leg = pleg;
        this.sprayball = psprayball;
    }

    public void showinfo() {
        System.out.println("This Tank Has");
        System.out.println("Manhole of Type " + Manhole);
        System.out.println("Airvent of Type " + airvent);
        System.out.println("Sprayball of Type " + sprayball);
        System.out.println("Shell of Type " + Shell);
        System.out.println("Leg of type " + leg);
    }

}

class TankBuilder {

    String Manhole;
    String airvent;
    String sprayball;
    String leg;
    String Shell;

    public TankBuilder setManhole(String pManhole) {
        System.out.println("Set Manhole to " + pManhole);
        this.Manhole = pManhole;
        return this;
    }

    public TankBuilder setairvent(String pairvent) {
        System.out.println("Set Airvent to " + pairvent);
        this.airvent = pairvent;
        return this;
    }

    public TankBuilder setsprayball(String psprayball) {
        System.out.println("Set Sprayball to " + psprayball);
        this.sprayball = psprayball;
        return this;
    }

    public TankBuilder setleg(String pleg) {
        System.out.println("Set leg to " + pleg);
        this.leg = pleg;
        return this;
    }

    public TankBuilder setShell(String pShell) {
        System.out.println("Set Shell to " + pShell);
        this.Shell = pShell;
        return this;
    }

    public Tanks getTank() {
        return new Tanks(Manhole, airvent, sprayball, Shell, leg);
    }

}

public class Amul {
    public static void main(String[] args) {
        TankBuilder atpl = new TankBuilder();
        Tanks Storage = atpl.getTank();
        Storage.showinfo();
        System.out.println(Storage);
        Tanks HMST = atpl.setManhole("Top").setShell("1400").setairvent("Side").getTank();
        System.out.println(HMST);
        HMST.showinfo();

    }

}
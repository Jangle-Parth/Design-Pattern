interface adapterInterface {
    void weld();
}

class Tank {
    int dia;
    Manhole mh;

    Tank(int dia, Manhole m) {
        this.dia = dia;
        this.mh = m;
        fixManhole();
    }

    public void fixManhole() {
        ManholeAdapter mAdapter = new ManholeAdapter(mh, this);
        mAdapter.weld();
    }

}

class Manhole {
    int dia;

    Manhole(int dia) {
        this.dia = dia;
    }
}

class ManholeAdapter implements adapterInterface {
    Manhole mh;
    Tank t;

    ManholeAdapter(Manhole m, Tank t) {
        this.mh = m;
        this.t = t;

    }

    public void weld() {
        System.out.println();
        System.out.println("Doing Welding");
        System.out.println("Welding Done");
    }
}

public class adapter {
    public static void main(String[] args) {
        Manhole nestleManhole = new Manhole(320);
        Manhole amulManhole = new Manhole(280);

        Tank nestleTank = new Tank(2500, nestleManhole);
        Tank amulTank = new Tank(3000, amulManhole);
    }
}

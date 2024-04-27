public class singleton3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(
                new Runnable() {
                    public void run() {
                        COMPANY ATPL = COMPANY.createcompany();
                    }
                });
        Thread t2 = new Thread(
                new Runnable() {
                    public void run() {
                        COMPANY AMUL = COMPANY.createcompany();
                    }
                });
        t1.start();
        t2.start();
    }
}

class COMPANY {
    static COMPANY obj;

    private COMPANY() {
        System.out.println("COMPANY CREATED SUCESSFULLY");
    }

    public static synchronized COMPANY createcompany() {
        if (obj == null) {
            obj = new COMPANY();
        }
        return obj;
    }
}
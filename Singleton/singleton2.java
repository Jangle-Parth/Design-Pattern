public class singleton2 {
    public static void main(String[] args) {
        COMPANY ATPL = COMPANY.createcompany();
        COMPANY AMUL = COMPANY.createcompany();
    }
}

class COMPANY {
    static COMPANY obj;

    private COMPANY() {
        System.out.println("COMPANY CREATED SUCESSFULLY");
    }

    public static COMPANY createcompany() {
        if (obj == null) {
            obj = new COMPANY();
        }
        return obj;
    }
}
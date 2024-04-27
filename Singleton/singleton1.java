public class singleton1 {
    public static void main(String[] args) {
        COMPANY ATPL = COMPANY.createcompany();
        COMPANY ATPL1 = COMPANY.createcompany();
    }
}

class COMPANY {
    static COMPANY ATPL = new COMPANY();

    private COMPANY() {
        System.out.println("COMPANY CREATED SUCCESFULLY");
    }

    public static COMPANY createcompany() {
        return ATPL;
    }
}
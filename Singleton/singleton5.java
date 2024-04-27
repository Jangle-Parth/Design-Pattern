public class singleton5 {
    public static void main(String[] args) {
        COMPANY AMUL = COMPANY.INSTANCE;
        COMPANY AMUL2 = COMPANY.INSTANCE;
    }
}

enum COMPANY {
    INSTANCE;

    COMPANY() {
        System.out.println("Object Created");
    }

}
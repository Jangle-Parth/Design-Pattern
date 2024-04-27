abstract class State {
    Order order;

    State(Order order) {
        this.order = order;
    }

    public abstract void PendingConfirmation();

    public abstract void Confirmed();

    public abstract void inProduction();

    public abstract void Dispatch();
}

class PendingState extends State {

    PendingState(Order order) {
        super(order);
    }

    public void PendingConfirmation() {
        System.out.println("Order Confirmation is Pending");
        order.changeState(new ConfirmedState(order));
    }

    public void Confirmed() {
        System.out.println("Waiting for Confirmation of " + order.getName());
    }

    public void inProduction() {
        System.out.println("Waiting for Confirmation of " + order.getName());
    }

    public void Dispatch() {
        System.out.println("Waiting for Confirmation of " + order.getName());
    }
}

class ConfirmedState extends State {

    public ConfirmedState(Order Order) {
        super(Order);
    }

    public void PendingConfirmation() {
        System.out.println("Order Already Confirmed for " + order.getName());
    }

    public void Confirmed() {
        order.changeState(new ConfirmedState(order));
        System.out.println("Advance Received for " + order.getName());
    }

    public void inProduction() {
        System.out.println("Waiting to Get Material of " + order.getName());
    }

    public void Dispatch() {
        System.out.println("Waiting for tank to be Produced");
    }
}

class ProductionState extends State {

    ProductionState(Order Order) {
        super(Order);
    }

    public void PendingConfirmation() {
        System.out.println("Order Already Confirmed for " + order.getName());
    }

    public void Confirmed() {
        System.out.println("Advance Received for " + order.getName());
        System.out.println("Material Sent for " + order.getName());
    }

    public void inProduction() {
        System.out.println("Production Stated for " + order.getName());
        order.changeState(new DispatchState(order));
    }

    public void Dispatch() {
        System.out.println("Waiting for tank to be Produced");
    }
}

class DispatchState extends State {

    DispatchState(Order Order) {
        super(Order);
    }

    public void PendingConfirmation() {
        System.out.println("Order Already Confirmed for" + order.getName());
    }

    public void Confirmed() {
        System.out.println("Advance Received for " + order.getName());
        System.out.println("Material Sent for " + order.getName());
    }

    public void inProduction() {
        System.out.println("Production Completed for " + order.getName());
    }

    public void Dispatch() {
        System.out.println("Dispatched order of " + order.getName());
    }
}

class Order {
    private State state;
    private String name;

    public String getName() {
        return name;
    }

    public Order(String name) {
        this.name = name;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}

public class tank {
    public static void main(String[] args) {
        Order tetrapack = new Order("Tetrapack");
        tetrapack.changeState(new PendingState(tetrapack));
        tetrapack.getState().Confirmed();
        Order Nestle = new Order("Nestle");
        Nestle.changeState(new ConfirmedState(Nestle));
        Nestle.getState().inProduction();
        Order Amul = new Order("Amul");
        Amul.changeState(new ProductionState(Amul));
        Amul.getState().Dispatch();
        tetrapack.changeState(new ConfirmedState(tetrapack));
        Nestle.changeState(new ProductionState(Nestle));
        Order CocaCola = new Order("Coca-Cola");
        CocaCola.changeState(new DispatchState(CocaCola));
        CocaCola.getState().Dispatch();

    }
}

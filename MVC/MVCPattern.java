package MVC;

class Tank {
    String Type;
    String Client;

    Tank(String type, String client) {
        this.Type = type;
        this.Client = client;
    }

}

class TankView {
    public void tankinfo(String type, String client) {
        System.out.println("Tank Name: " + type);
        System.out.println("Client Name: " + client);
    }
}

class TankController {
    Tank model;
    TankView view;

    public TankController(Tank model, TankView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        view.tankinfo(model.Type, model.Client);
    }
}

public class MVCPattern {
    public static void main(String[] args) {
        Tank model = new Tank("Milk Storage", "Amul");
        TankView view = new TankView();
        TankController controller = new TankController(model, view);
        controller.updateView();
        controller.model.Type = "Acid Storage tank";
        controller.model.Client = "Coca-Cola";
        controller.updateView();
    }

}

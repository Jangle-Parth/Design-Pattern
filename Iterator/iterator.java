package Iterator;

import java.util.ArrayList;

class Part {
    String name;
    int cost;

    Part(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public double getcost() {
        return cost;

    }
}

class TankIterator {
    int currentIndex = 0;
    ArrayList<Part> parts;

    public TankIterator(ArrayList<Part> part) {
        this.parts = part;
    }

    public boolean hasNext() {
        return currentIndex < parts.size();
    }

    public Part next() {
        if (!hasNext()) {
            System.out.println("No such Element found");
        }
        return parts.get(currentIndex++);
    }
}

public class iterator {
    public static void main(String[] args) {
        ArrayList<Part> parts = new ArrayList<>();
        parts.add(new Part("Manhole", 1000));
        parts.add(new Part("Airvent", 100));
        parts.add(new Part("Gasket", 400));
        parts.add(new Part("Sprayball", 6000));
        TankIterator t = new TankIterator(parts);
        int totalcost = 0;
        while (t.hasNext()) {
            totalcost += t.next().getcost();
        }

        System.out.println("Total Cost: " + totalcost);

    }
}

package presenter;

import model.Toy;

import java.util.LinkedList;
import java.util.Queue;

public interface ToyModel {
    void addToy(String name, int weight);
    LinkedList<Toy> getProducts();
    Toy getToy();
}

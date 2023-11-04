package presenter;

import model.Toy;

import java.util.Collection;

public interface ToyModel {
    void addToy(String name, int weight);
    Collection<Toy> loadProducts();
    void removeToy(Toy toy);
    Toy getToy();
}

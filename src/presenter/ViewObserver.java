package presenter;


import model.Toy;

import java.util.LinkedList;

public interface ViewObserver {
    Toy onGetToy();

    void onAddProducts();
    LinkedList<Toy> onLoadProducts();

    void showProducts(LinkedList<Toy> toys);
}

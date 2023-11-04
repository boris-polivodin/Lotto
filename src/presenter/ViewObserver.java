package presenter;


import model.Toy;

public interface ViewObserver {
    Toy onGetToy();

    void onLoadProducts();
}

package presenter;

import model.Toy;

import java.util.Collection;

public interface View {
    void showToys(Collection<Toy> toys);
    void showLoadToyResult();
    void getToy();

    void setObserver(ViewObserver observer);
    String promptValue();
}

package presenter;

import model.Toy;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public interface View {
    void showToys(LinkedList<Toy> toys);
    void setObserver(ViewObserver observer);
    String promptValue();
}

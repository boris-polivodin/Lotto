package view;

import model.Toy;
import presenter.View;
import presenter.ViewObserver;

import java.util.Collection;
import java.util.Scanner;

public class ToysView implements View {

    private ViewObserver observer;

    @Override
    public void showToys(Collection<Toy> toys) {
        toys.forEach(System.out::println);
    }

    @Override
    public void showLoadToyResult() {
        if (observer == null) {
            observer.onLoadProducts();
        }
    }


    @Override
    public void getToy() {
        if (observer == null) {
            observer.onGetToy();
        }
    }

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public String promptValue() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите название и вес через пробел: ");
        return sc.nextLine();
    }
}

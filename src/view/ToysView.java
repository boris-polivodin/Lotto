package view;

import model.Toy;
import presenter.View;
import presenter.ViewObserver;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ToysView implements View {

    private ViewObserver observer;

    @Override
    public void showToys(LinkedList<Toy> toys) {
        toys.forEach(System.out::println);
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

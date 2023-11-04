package model;

import presenter.ToyModel;

import java.util.*;

public class ToyQueue implements ToyModel {

    Queue<Toy> toys;
    LinkedList<Toy> products;
    int total;

    public ToyQueue() {
        toys = new PriorityQueue<>(Comparator.comparingInt(Toy::getWeight));
        products = new LinkedList<>();
    }

    @Override
    public void addToy(String name, int weight) {
        try {
            toys.add(new Toy(name, weight));
        } catch (Exception e) {
             throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public LinkedList<Toy> getProducts() {
        while (!toys.isEmpty()) {
            products.add(toys.poll());
        }
        total = 0;
        for (Toy toy: products) {
            total += toy.getWeight();
        }
        return products;
    }

    @Override
    public Toy getToy() {
        Random rnd = new Random();
        try {
            int index = rnd.nextInt(1, total + 1);
            int comparisonValue = 0;
            for (Toy toy: products) {
                comparisonValue += toy.getWeight();
                if (index <= comparisonValue) {
                    return toy;
                }
            }
            return null;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}

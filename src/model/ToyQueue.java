package model;

import presenter.ToyModel;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyQueue implements ToyModel {

    Collection<Toy> toys;

    public ToyQueue() {
//        Comparator<Toy> toyWeightComparator
//                = Comparator.comparing(Toy::getWeight);
        toys = new PriorityQueue<>(Comparator.comparingInt(Toy::getWeight));
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
    public Collection<Toy> loadProducts() {
        return toys;
    }

    @Override
    public void removeToy(Toy toy) {
        try {
            toys.remove(toy);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Toy getToy() {
        int total = 0;
        for (Toy toy: toys) {
            total += toy.getWeight();
        }
        Random rnd = new Random();
        int index = rnd.nextInt(1, total + 1);
        int comparisonValue = 0;

        for (Toy toy: toys) {
            comparisonValue += toy.getWeight();
            if (index <= comparisonValue) {
                return toy;
            }

        }
        return null;
    }
}

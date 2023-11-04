package model;

public class Toy {

    private static int count;
    private final int id;
    private String name;
    private int weight;

    {
        count++;
    }

    public Toy(String name, int weight) {
        this.name = name;
        this.weight = weight;
        id = count;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + " { id= " + id + ", weight= " + weight + " }";
    }
}

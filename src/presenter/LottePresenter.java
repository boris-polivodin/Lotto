package presenter;


import model.Toy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class LottePresenter implements ViewObserver{

    private final ToyModel model;
    private final View view;

    private StringBuilder sb = new StringBuilder();

    private int count;

    public LottePresenter(ToyModel model, View view, int count) {
        this.model = model;
        this.view = view;
        this.count = count;
        view.setObserver(this);
    }

    @Override
    public Toy onGetToy() {
        Toy result = model.getToy();
        if (result != null) {
            sb.append(result).append("\n");
        }
        return result;
    }

    @Override
    public void onAddProducts() {
        for (int i = 0; i < count; i++) {
            String[] response = view.promptValue().split(" ");
            try {
                model.addToy(response[0], Integer.parseInt(response[1]));
            } catch (NumberFormatException e1) {
                throw new RuntimeException("Не корректный формат введенных данных");
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new RuntimeException("Не корректный формат введенных данных");
            }
        }
    }

    @Override
    public LinkedList<Toy> onLoadProducts() {;
        return model.getProducts();
    }

    @Override
    public void showProducts(LinkedList<Toy> toys) {
        view.showToys(toys);
    }

    public void writeFile(String name, String result) throws IOException {
        if (sb.isEmpty())
            throw new RuntimeException("Нет данных для записи в файл.");

        sb.append(result);

        try (FileWriter fw = new FileWriter(name, false)) {
            fw.write(sb.toString());
            fw.write("\n");
        }
    }

}

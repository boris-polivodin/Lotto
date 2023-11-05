import model.Toy;
import model.ToyQueue;
import presenter.LottePresenter;
import presenter.ToyModel;
import presenter.View;
import view.ToysView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        double count1 = 0;
        double count2 = 0;
        double count3 = 0;
        double count4 = 0;
        int loopIterations = 10;
        int countObjects = 3;
        String fileName = "result.txt";

        if (countObjects > 4) {
            System.out.println("Задавать не более 4-х объектов");
            return;
        }

        View view = new ToysView();
        ToyModel model = new ToyQueue();
        LottePresenter presenter = new LottePresenter(model, view, countObjects);
        presenter.onAddProducts();
        presenter.showProducts(presenter.onLoadProducts());
        System.out.println();
        for (int i = 0; i < loopIterations; i++) {
            Toy toy = presenter.onGetToy();
            if (toy != null) {
                System.out.println(toy);
                if (toy.getId() == 1) {
                    count1++;
                } else if (toy.getId() == 2) {
                    count2++;
                } else if (toy.getId() == 3) {
                    count3++;
                } else if (toy.getId() == 4) {
                    count4++;
                }
            }
        }

        System.out.println();
        String result = String.format("id= 1: %.0f%%   id= 2: %.0f%%   id= 3: %.0f%%   id= 4: %.0f%%"
                                    , count1/ loopIterations*100, count2/ loopIterations*100
                                    , count3/ loopIterations*100, count4/ loopIterations*100);
        System.out.println(result);

        try {
            presenter.writeFile(fileName, result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
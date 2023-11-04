import model.Toy;
import model.ToyQueue;
import presenter.LottePresenter;
import presenter.ToyModel;
import presenter.View;
import view.ToysView;

public class Main {
    public static void main(String[] args) {
        double count1 = 0;
        double count2 = 0;
        double count3 = 0;
        double count4 = 0;
        int total = 100;
        View view = new ToysView();
        ToyModel model = new ToyQueue();
        LottePresenter presenter = new LottePresenter(model, view, 3);
        presenter.onAddProducts();
        presenter.showProducts(presenter.onLoadProducts());
        System.out.println();
        for (int i = 0; i < total; i++) {
            Toy toy = presenter.onGetToy();
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

        System.out.println();
        System.out.printf("1= %.0f%%   2= %.0f%%   3= %.0f%%   4= %.0f%%"
                , count1/ total*100, count2/ total*100
                , count3/ total*100, count4/ total*100);

    }
}
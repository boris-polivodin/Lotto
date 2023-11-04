import model.Toy;
import model.ToyQueue;
import presenter.LottePresenter;
import presenter.ToyModel;
import presenter.View;
import view.ToysView;

public class Main {
    public static void main(String[] args) {
        View view = new ToysView();
        ToyModel model = new ToyQueue();
        LottePresenter presenter = new LottePresenter(model, view, 3);
        presenter.onLoadProducts();
        for (int i = 0; i < 10; i++) {
            System.out.println(presenter.onGetToy());
        }
    }
}
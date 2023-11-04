package presenter;


import model.Toy;

public class LottePresenter implements ViewObserver{

    private final ToyModel model;
    private final View view;

    private int count;

    public LottePresenter(ToyModel model, View view, int count) {
        this.model = model;
        this.view = view;
        this.count = count;
        view.setObserver(this);
    }

    @Override
    public Toy onGetToy() {
        return model.getToy();
    }

    @Override
    public void onLoadProducts() {;
        for (int i = 0; i < count; i++) {
            String[] response = view.promptValue().split(" ");
            try {
                model.addToy(response[0], Integer.parseInt(response[1]));
            } catch (NumberFormatException e) {
                throw new RuntimeException("Не корректный формат введенных данных");
            }
        }
        view.showToys(model.loadProducts());
    }
}

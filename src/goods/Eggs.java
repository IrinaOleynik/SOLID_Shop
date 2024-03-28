package goods;

public class Eggs extends Goods implements Food {
    private final String name = "Яйца";
    private final int price = 120;
    private final int weight = 50;
    protected int shelfDate = 7;
    protected String id = "E001";


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getShelfDate() {
        if (shelfDate > 0) {
            return this.shelfDate + " дня";
        } else {
            return outOfShelfDate();
        }
    }

    @Override
    public String outOfShelfDate() {
        return "срок годности продукта истек";
    }

    @Override
    public void reduceShelfDate() {
        this.shelfDate--;
    }

    @Override
    public String toString() {
        return name + ": " + price + " руб.";
    }
}

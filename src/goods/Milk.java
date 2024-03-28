package goods;

public class Milk extends Goods implements Food {
    protected String name = "Молоко";
    protected int price = 68;
    protected int weight = 515;
    protected int shelfDate = 3;
    protected String id = "M002";

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
        if (shelfDate < 1) {
            return "Срок годности продукта истек";
        }
        return "";
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

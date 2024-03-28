package goods;

public class PaperTowels extends Goods implements Toiletries {
    protected String name = "Бумажные полотенца";
    protected int price = 340;
    protected int weight = 200;
    protected String id = "PT002";

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
    public String getUniqueInfo() {
        if (isSoft()) {
            return "мягкие бумажные полотенца";
        } else {
            return "обычные бумажные полотенца";
        }
    }

    @Override
    public boolean isSoft() {
        return false;
    }

    @Override
    public String toString() {
        return name + ": " + price + " руб.";
    }
}

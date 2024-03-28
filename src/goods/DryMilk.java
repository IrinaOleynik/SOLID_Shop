package goods;

public class DryMilk extends Goods implements Food, ChildGoods {
    protected String name = "Сухое молоко";
    protected int price = 250;
    protected int weight = 100;
    protected int shelfDate = 90;
    protected String id = "M001";

    @Override
    public String getUniqueInfo() {
        if (isHypoallergenic()) {
            return "гипоаллергенный продукт";
        } else {
            return "содержит аллергены";
        }
    }

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
    public boolean isHypoallergenic() {
        return true;
    }

    @Override
    public String outOfShelfDate() {
        if (shelfDate < 1) {
            return "срок годности продукта истек";
        }
        return "";
    }

    @Override
    public void reduceShelfDate() {
        shelfDate--;
    }

    @Override
    public String toString() {
        return name + ": " + price + " руб.";
    }
}

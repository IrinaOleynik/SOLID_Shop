package goods;

public class KidsPaperTowels extends Goods implements Toiletries, ChildGoods {
    protected String name = "Детские бумажные полотенца";
    protected int price = 360;
    protected int weight = 200;
    protected String id = "PT001";

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
        String soft = "";
        String hypoallergenic = "";
        if (isSoft()) {
            soft = "мягкие бумажные полотенца";
        } else {
            soft = "обычные бумажные полотенца";
        }
        if (isHypoallergenic()) {
            hypoallergenic = "гипоаллергенный продукт";
        } else {
            hypoallergenic = "содержит аллергены";
        }
        return soft + ", " + hypoallergenic;
    }

    @Override
    public boolean isHypoallergenic() {
        return false;
    }

    @Override
    public boolean isSoft() {
        return true;
    }

    @Override
    public String toString() {
        return name + ": " + price + " руб.";
    }
}

package goods;

import java.util.Objects;

public abstract class Goods {

    protected String name;
    protected int price;
    protected int weight;
    protected int shelfDate;
    protected String id;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public String getShelfDate() {
        return "срок годности продукта не ограничен";
    }

    public void setShelfDate(int shelfDate) {
        this.shelfDate = shelfDate;
    }

    public String getUniqueInfo() {
        return "у данного товара нет уникальной информации";
    }

    public void getFullInfo() {
        System.out.println("Наименование товара: " + getName());
        System.out.println("Вес: " + getWeight());
        System.out.println("Цена: " + getPrice());
        System.out.println("Срок годности  продукта: " + getShelfDate());
        System.out.println("Уникальная информация: " + getUniqueInfo());

    }
}

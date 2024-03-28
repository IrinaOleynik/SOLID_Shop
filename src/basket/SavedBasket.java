package basket;

import goods.Goods;

import java.util.Map;

public class SavedBasket {
    protected Map<Goods, Integer> basket;
    private int sum;

    public SavedBasket(Map<Goods, Integer> savedBasket, int sum) {
        this.basket = savedBasket;
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public Map<Goods, Integer> getBasket() {
        return basket;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Goods, Integer> kv : basket.entrySet()) {
            sb.append(kv.getKey() + " " + kv.getValue() + "шт.");
            sb.append("\n");
        }
        sb.append("Итого: " + getSum());
        return sb.toString();
    }
}

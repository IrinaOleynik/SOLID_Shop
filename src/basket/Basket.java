package basket;

import goods.Goods;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private static Map<Goods, Integer> basket = new HashMap<>();
    protected static int sum;

    public static void addToBasket(Goods key, Map<Integer, Goods> stock) {
        if (!stock.containsValue(key)) {
            System.out.println("У нас нет такого товара");
        } else if (basket.containsKey(key)) {
            basket.put(key, basket.get(key) + 1);
            sum += key.getPrice();
        } else {
            basket.put(key, 1);
            sum += key.getPrice();
        }
    }

    public static void removeFromBasket(String key) {
        Goods toRemove = null;
        for (Map.Entry<Goods, Integer> kv : basket.entrySet()) {
            if (kv.getKey().getName().toLowerCase().equals(key.toLowerCase())) {
                if (kv.getValue() > 1) {
                    basket.put(kv.getKey(), basket.get(kv.getValue()) - 1);
                    sum -= kv.getKey().getPrice();
                } else {
                    toRemove = kv.getKey();
                    sum -= kv.getKey().getPrice();
                }
            }
        }
        if (toRemove == null) {
            System.out.println("В вашей корзине нет такого товара");
        } else {
            basket.remove(toRemove);
        }
    }

    public static Map<Goods, Integer> getBasket() {
        return basket;
    }

    public static int getSum() {
        return sum;
    }

    public static void cleanUpBasket() {
        basket.clear();
        sum = 0;
    }

}



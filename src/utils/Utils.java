package utils;

import basket.SavedBasket;
import goods.Goods;

import static basket.Basket.*;
import static orders.Orders.getOrders;
import static storage.Stock.getStock;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    static final Map<Integer, Goods> stock = getStock();
    static Map<Goods, Integer> basket = getBasket();
    static Map<Integer, SavedBasket> orders = getOrders();

    public static void printStock() {
        System.out.println("Список товаров:");
        for (Map.Entry<Integer, Goods> kv : stock.entrySet()) {
            System.out.println(kv.getKey() + ". " + kv.getValue());
        }
    }

    public static void printBasket() {
        if (basket.isEmpty()) {
            System.out.println("Ваша корзина пуста");
        } else {
            System.out.println("Ваша корзина:");
            for (Map.Entry<Goods, Integer> kv : basket.entrySet()) {
                System.out.println(kv.getKey() + " " + kv.getValue() + "шт.");
            }
            System.out.println("Итого: " + getSum());
        }
    }

    public static void printMyOrders() {
        for (Map.Entry<Integer, SavedBasket> kv : orders.entrySet()) {
            System.out.println("Заказ номер " + kv.getKey() + "\n" + kv.getValue());
        }
    }

    public static void printOrder(int key) {
        System.out.println("Ваш заказ номер " + key);
        System.out.println(orders.get(key));
    }

    public static void printSavedBasket(SavedBasket savedBasket) {
        Map<Goods, Integer> basket = savedBasket.getBasket();
        for (Map.Entry<Goods, Integer> kv : basket.entrySet()) {
            System.out.println(kv.getKey() + " " + kv.getValue() + "шт.");
        }
        System.out.println("Итого: " + savedBasket.getSum());
    }

    public static Map<Integer, Goods> filterByKeyWord(String keyWord) {
        int number = 1;
        Map<Integer, Goods> byKeyWord = new HashMap<>();
        for (Map.Entry<Integer, Goods> kv : stock.entrySet()) {
            if (kv.getValue().getName().toLowerCase().contains(keyWord.toLowerCase())) {
                byKeyWord.put(number, kv.getValue());
                number++;
            }
        }
        return byKeyWord;
    }

    public static Map<Integer, Goods> filterByPrice(int lowest, int highest) {
        Map<Integer, Goods> byPrice = new HashMap<>();
        int number = 1;
        for (Map.Entry<Integer, Goods> kv : stock.entrySet()) {
            if (kv.getValue().getPrice() >= lowest && kv.getValue().getPrice() <= highest) {
                byPrice.put(number, kv.getValue());
                number++;
            }
        }
        return byPrice;
    }

    public static void printFiltered(Map<Integer, Goods> filtredMap) {
        for (Map.Entry<Integer, Goods> kv : filtredMap.entrySet()) {
            System.out.println(kv.getKey() + ". " + kv.getValue());
        }
    }
}

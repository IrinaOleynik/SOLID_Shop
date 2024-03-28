package orders;

import basket.SavedBasket;
import goods.Goods;
import java.util.HashMap;
import java.util.Map;
import static basket.Basket.getSum;

public class Orders {
    protected static Map<Integer, SavedBasket> orders = new HashMap<>();
    private static int orderId = 1;

    public static Map<Integer, SavedBasket> getOrders() {
        return orders;
    }

    public static void saveOrder(Map<Goods, Integer> basket) {
        Map<Goods, Integer> cloneBasket = new HashMap<>(basket);
        SavedBasket savedBasket = new SavedBasket(cloneBasket, getSum());
        orders.put(orderId, savedBasket);
        orderId++;
    }

    public static void repeatOrder(int key) {

        orders.put(orderId, orders.get(key));
        orderId++;

    }

    public static void deleteOrder(int key) {
        orders.remove(key);
    }

}

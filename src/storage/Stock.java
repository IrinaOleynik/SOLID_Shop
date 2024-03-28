package storage;

import goods.*;
import java.util.HashMap;
import java.util.Map;

public class Stock {
    private static final Map<Integer, Goods> storage = getStock();

    public static Map<Integer, Goods> getStock() {
        final Map<Integer, Goods> storage = new HashMap<>();
        storage.put(1, new Milk());
        storage.put(2, new DryMilk());
        storage.put(3, new Eggs());
        storage.put(4, new PaperTowels());
        storage.put(5, new KidsPaperTowels());
        return storage;
    }
}

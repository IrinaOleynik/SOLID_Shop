import goods.*;
import basket.*;

import static basket.Basket.*;
import static orders.Orders.*;
import static storage.Stock.getStock;
import static utils.Utils.*;

import java.util.Map;
import java.util.Scanner;

public class Main {
    static final Map<Integer, Goods> stock = getStock();
    static Map<Goods, Integer> basket = getBasket();
    static Map<Integer, SavedBasket> orders = getOrders();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            printStock();

            System.out.println("Выберите действие:");
            System.out.println("1. Добавить товар в корзину");
            System.out.println("2. Перейти к корзине");
            System.out.println("3. Включить фильтрацию товаров");
            System.out.println("4. Посмотреть полную информацию о товаре");
            System.out.println("5. Перейти в мои заказы");

            int action = Integer.parseInt(scanner.nextLine());

            switch (action) {
                case 1:
                    addProduct(stock);
                    break;
                case 2:
                    myBasket();
                    break;
                case 3:
                    System.out.println("1. Фильтрация по ключевым словам");
                    System.out.println("2. Фильтрация по цене");
                    int filter = Integer.parseInt(scanner.nextLine());
                    switch (filter) {
                        case 1:
                            System.out.println("Введите слово");
                            String keyWord = scanner.nextLine();
                            Map<Integer, Goods> filteredByKeyWord = filterByKeyWord(keyWord);
                            if (filteredByKeyWord.get(1) == null) {
                                System.out.println("По вашему запросу ничего не найдено");
                            } else {
                                filteredStock(filteredByKeyWord);
                            }
                            break;
                        case 2:
                            System.out.println("Введите минимальную и максимальную суммы через запятую");
                            String[] price = scanner.nextLine().split(",");
                            Map<Integer, Goods> filteredByPrice = filterByPrice(Integer.parseInt(price[0]),
                                    Integer.parseInt(price[1]));
                            if (filteredByPrice.isEmpty()) {
                                System.out.println("По вашему запросу ничего не найдено");
                            } else {
                                filteredStock(filteredByPrice);
                            }
                            break;
                    }
                    break;
                case 4:
                    printFullInfo();
                    break;
                case 5:
                    printMyOrders();
                    myOrders();
            }
        }
    }

    private static void addProduct(Map<Integer, Goods> stock) {
        System.out.println("Введите номер товара, который хотите добавить в коризу");
        int productNumder = Integer.parseInt(scanner.nextLine());
        addToBasket(stock.get(productNumder), stock);
        System.out.println("Продолжим добавлять в корзину?");
        if (scanner.nextLine().equals("yes")) {
            addProduct(stock);
        }
    }

    private static void myBasket() {
        printBasket();
        System.out.println("Выберите действие:");
        System.out.println("1. Удалить товар из корзины");
        System.out.println("2. Сохранить в <Мои заказы>");
        System.out.println("3. Очистить корзину");
        System.out.println("4. Вернуться в главное меню");
        int action = Integer.parseInt(scanner.nextLine());
        switch (action) {
            case 1:
                System.out.println("Введите наименование товара, который хотите убрать из коризины");
                String toRemove = scanner.nextLine();
                removeFromBasket(toRemove);
                break;
            case 2:
                saveOrder(basket);
                break;
            case 3:
                cleanUpBasket();
                break;
            case 4:
                break;
        }
    }

    private static void filteredStock(Map<Integer, Goods> filtered) {
        System.out.println("Вот что мы нашли:");
        printFiltered(filtered);
        System.out.println("Добавим что нибудь в корзину?");
        if (scanner.nextLine().equals("yes")) {
            addProduct(filtered);
        }
    }

    public static void printFullInfo() {
        System.out.println("Введите номер товара");
        stock.get(Integer.parseInt(scanner.nextLine())).getFullInfo();
        System.out.println("Посмотреть другой товар?");
        if (scanner.nextLine().equals("yes")) {
            printFullInfo();
        }
    }

    public static void myOrders() {
        System.out.println("1. Повторить заказ");
        System.out.println("2. Удалить заказ");
        System.out.println("3. Оформить заказ");
        System.out.println("4. Вернуться в главное меню");
        int action = Integer.parseInt(scanner.nextLine());
        switch (action) {
            case 1:
                System.out.println("Введите номер заказа");
                int orderToRepeat = Integer.parseInt(scanner.nextLine());
                if (orders.containsKey(orderToRepeat)) {
                    repeatOrder(orderToRepeat);
                    System.out.println("Ваша заказ №" + orderToRepeat + " успешно повторен");
                    printOrder(orderToRepeat);
                } else {
                    System.out.println("Неверный номер заказа");
                }
                break;
            case 2:
                System.out.println("Введите номер заказа");
                int orderToDelete = Integer.parseInt(scanner.nextLine());
                if (orders.containsKey(orderToDelete)) {
                    deleteOrder(orderToDelete);
                    System.out.println("Ваша заказ №" + orderToDelete + " успешно удален");
                } else {
                    System.out.println("Неверный номер заказа");
                }
                break;
            case 3:
                System.out.println("Введите номер заказа");
                if (orders.containsKey(Integer.parseInt(scanner.nextLine()))) {
                    System.out.println("Спасибо за покупку!");
                } else {
                    System.out.println("Неверный номер заказа");
                }
                break;
            case 4:
                break;
        }
    }
}

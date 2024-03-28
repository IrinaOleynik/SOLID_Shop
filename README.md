# При работе с программой были использованы следующие принципы:
___
### Magic: 
- подсчет суммы товаров происходит путем обращения к цене товаров через геттеры, а не путем сложения цен в их чистом виде.
  https://github.com/IrinaOleynik/SOLID_Shop/blob/9ed3f5d8cb93fe20bca5a04e479f8babdca8feee/src/basket/Basket.java#L20
  
### DRY: 
-  в методах `filtredStock` и `addProduct` для добавления товара в корзину используется метод `addProduct`. Для взаимодействия пользователя со списком товаров, отфильтрованном вне зависимости от способа фильтрации товаров, используется метод `filtredStock`.  Это позволяет избежать дублированния кода при выполнении единообразных операций;
https://github.com/IrinaOleynik/SOLID_Shop/blob/9ed3f5d8cb93fe20bca5a04e479f8babdca8feee/src/Main.java#L51
https://github.com/IrinaOleynik/SOLID_Shop/blob/9ed3f5d8cb93fe20bca5a04e479f8babdca8feee/src/Main.java#L62

## SOLID
___
### S (single responsibility principle): 
- класс ` Orders ` исполняет исключительно функции формирования списка заказов покупателя. Для формирования заказа (корзины) покупателя используется другой класс;
https://github.com/IrinaOleynik/SOLID_Shop/blob/9ed3f5d8cb93fe20bca5a04e479f8babdca8feee/src/orders/Orders.java#L9

### O (open-closed principle): 
- все товары наследуются от класса-родителя `Goods`, что позволяет добавлять товары с уникальными свойствами, при этом не меняя основной класс;
https://github.com/IrinaOleynik/SOLID_Shop/blob/9ed3f5d8cb93fe20bca5a04e479f8babdca8feee/src/goods/Goods.java#L5

### L (Liskov substitution principle): 
- все товары наследуются от класса `Goods` и могут быть использованы вместо класса-родителя. Например, при добавлении товара в корзину в методе `addToBasket` в параметры передаются наследники класса `Goods`;
https://github.com/IrinaOleynik/SOLID_Shop/blob/9ed3f5d8cb93fe20bca5a04e479f8babdca8feee/src/basket/Basket.java#L12

### I (interface segregation principle): 
- для товаров различных категорий были созданы различные интерфейсы: `Food`, `Toiletries` и `ChildGoods`;
https://github.com/IrinaOleynik/SOLID_Shop/blob/9ed3f5d8cb93fe20bca5a04e479f8babdca8feee/src/goods/Food.java#L3
https://github.com/IrinaOleynik/SOLID_Shop/blob/9ed3f5d8cb93fe20bca5a04e479f8babdca8feee/src/goods/Toiletries.java#L3
https://github.com/IrinaOleynik/SOLID_Shop/blob/9ed3f5d8cb93fe20bca5a04e479f8babdca8feee/src/goods/ChildGoods.java#L3

### D (dependency inversion principle):
- вместо наследования от  класса `PaperTowels`, класс `KidsPaperTowels` наследуется от класса `Goods` и имплементирует интерфейс `Toiletries`, таким образом класс `KidsPaperTowels` не зависит от реализации класса `PaperTowels`.
https://github.com/IrinaOleynik/SOLID_Shop/blob/9ed3f5d8cb93fe20bca5a04e479f8babdca8feee/src/goods/KidsPaperTowels.java#L3

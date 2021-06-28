package com.filipbartek;

public class Main {
    private static final StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 8);
        stockList.addStock(temp);

        temp = new StockItem("car", 10000.10, 3);
        stockList.addStock(temp);

        temp = new StockItem("plant", 6.70, 34);
        stockList.addStock(temp);

        temp = new StockItem("fan", 35.89, 50);
        stockList.addStock(temp);

        temp = new StockItem("guitar", 368.25, 47);
        stockList.addStock(temp);

        System.out.println(stockList);

        temp = new StockItem("plant", 6.47, 7);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket philipsBasket = new Basket("Filip");
        sellItem(philipsBasket, "plant", 2);
        System.out.println(philipsBasket);

        System.out.println("Car one");
        sellItem(philipsBasket, "car", 1);
        System.out.println(philipsBasket);

        System.out.println("Car two and three");
        sellItem(philipsBasket, "car", 2);
        System.out.println(philipsBasket);

        sellItem(philipsBasket, "spanner", 4);
        System.out.println(philipsBasket);

        sellItem(philipsBasket, "cake", 4);
        sellItem(philipsBasket, "bread", 47);
        System.out.println(philipsBasket);
        System.out.println(stockList);
    }

    public static void sellItem(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell this shit known as " + item);
            return;
        }
        if (stockList.sellStock(item, quantity) != 0){
            basket.addToBasket(stockItem, quantity);
        }
    }
}

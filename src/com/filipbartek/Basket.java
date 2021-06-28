package com.filipbartek;

import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public void addToBasket(StockItem item, int quantity){
        if (item != null && quantity > 0){
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\nShopping Basket\n" + name + " contains " + list.size() + " items.\n");
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()){
                   s.append(item.getKey())
                    .append(". ")
                    .append(item.getValue())
                    .append(" purchased.\n");
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost: " + totalCost;
    }
}

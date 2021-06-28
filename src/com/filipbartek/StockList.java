package com.filipbartek;

import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public void addStock(StockItem item){
        if (item != null){
            StockItem inStock = list.getOrDefault(item.getName(), item);
            if (inStock != item){
                item.adjustStock(inStock.getQuantityInStock());
            }
            list.put(item.getName(), item);
        }
    }

    public int sellStock(String item, int quantity){
        StockItem inStock = list.getOrDefault(item, null);
        if ((inStock != null) && (inStock.getQuantityInStock() >= quantity) && (quantity > 0)){
             inStock.adjustStock(-quantity);
             return quantity;
        }
        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\nStock List\n");
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()){
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.getQuantityInStock();
                   s.append(stockItem).append(". There are ")
                    .append(stockItem.getQuantityInStock())
                    .append(" in stock. Value of items: ")
                    .append(String.format("%.2f", itemValue))
                    .append("\n");
            totalCost += itemValue;
        }
        return s + "Total stock value: " + totalCost;
    }
}

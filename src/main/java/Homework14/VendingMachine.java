package Homework14;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    static Map<String, Integer> product = new HashMap<>();

    public void addItem(String name, int count) {
        product.put(name, count);
        System.out.println(product);
    }

    public void getItemCount(String name) {
        product.getOrDefault(name, 0);
        System.out.println(product);
    }

    public void removeItem(String name) {
        product.remove(name);
        System.out.println(product);
    }

    public void getTotalItemCount() {
        int totalCount = 0;
        for (int count : product.values()) {
            totalCount += count;
        }
        System.out.println(totalCount);
    }

    public void isItemAvailable(String name) {
        if (product.containsKey(name)) {
            product.get(name);
        }
        System.out.println(product);
    }
}

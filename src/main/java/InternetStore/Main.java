package InternetStore;

import static InternetStore.Category.PHONE;
import static InternetStore.Status.SHIPPED;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(1, "10", "Aram Harutyunyan", "01.06.2023", PHONE,"SAMSUNG", "SAMSUNG A32", 300, 1, true, 60, "Red", 300, SHIPPED);
        order.addOrder(order);
        order.getOrders();
        order.getId(1);
        order.getOrderByNumberOrBuyersFullName("Aram Harutyunyan");
        order.paging(1, 1);
        order.changeOrderStatus(1,SHIPPED);
        order.report();
        order.cancelOrder(1);
        order.orderShipped();
    }
}

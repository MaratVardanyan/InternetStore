package InternetStore;

import java.util.ArrayList;
import java.util.List;

public class Order {
    static List<Order> list = new ArrayList<>();
    private final int id;
    private final String brand;
    private final String OrderNumber;
    private final String ProductName;
    private final double Price;
    private final int quantity;
    private final String buyersFullName;
    private final boolean wasItBoughtWithDiscount;
    private int discount;
    private final String colour;
    private final Category category;
    private double paid;
    private Status orderStatus;
    private final String orderDate;
    private int canceledOrder;

    public Order(int id, String orderNumber, String buyersFullName, String orderDate, Category category, String brand,
                 String productName, double price, int quantity, boolean wasItBoughtWithDiscount, int discount,
                 String colour, double paid, Status orderStatus) {
        this.id = id;
        this.brand = brand;
        this.ProductName = productName;
        this.Price = price;
        this.quantity = quantity;
        this.buyersFullName = buyersFullName;
        this.wasItBoughtWithDiscount = wasItBoughtWithDiscount;
        this.setDiscount(wasItBoughtWithDiscount, discount);
        this.colour = colour;
        this.category = category;
        this.setPaid(wasItBoughtWithDiscount, paid);
        this.orderStatus = orderStatus;
        this.OrderNumber = orderNumber;
        this.orderDate = orderDate;
    }

    public void addOrder(Order order) {
        list.add(order);
    }

    public void getOrders() {
        if (list.isEmpty()) {
            System.out.println("null");
        }
        System.out.println(list);
    }

    public void getOrderByNumberOrBuyersFullName(String orderNumberOrBuyersFullName) {
        List<Order> newListName = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).buyersFullName.equals(orderNumberOrBuyersFullName) || list.get(i).OrderNumber
                    .equals(orderNumberOrBuyersFullName)) {
                newListName.add(list.get(i));
            }
        }
        if (newListName.isEmpty()) {
            System.out.println("null");
        }
        System.out.println(newListName);
    }

    public Order getId(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id == id) {
                return list.get(i);
            }
        }
        return null;
    }

    public void paging(int itemsPerPage, int page) {
        List<Order> ordersOfPage = new ArrayList<>();
        for (int i = itemsPerPage * (page - 1); i < itemsPerPage * page && i < list.size(); i++) {
            ordersOfPage.add(list.get(i));
        }
        if (ordersOfPage.isEmpty()) {
            System.out.println("There is no more orders");
        }
        System.out.println(ordersOfPage);
    }

    public void setPaid(boolean wasItBoughtWithDiscount, double paid) {
        if (wasItBoughtWithDiscount) {
            this.paid = this.quantity * (this.Price - (this.Price * this.discount / 100));
        } else {
            this.paid = this.quantity * paid;
        }
    }

    public void setDiscount(boolean wasItBoughtWithDiscount, int discount) {
        if (wasItBoughtWithDiscount) {
            this.discount = discount;
        } else {
            this.discount = 0;
        }
    }

    public void changeOrderStatus(int id, Status orderStatus) {
        Order order = getId(id);
        if (order != null) {
            order.setStatus(orderStatus);
            System.out.println("Order status changed successfully.");
        } else {
            System.out.println("Order not found.");
        }
    }

    private void setStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void report() {
        int countOfDeliveredOrders = 0;
        int countOfShippedOrders = 0;
        int ordersWithDiscount = 0;
        int totalRevenue = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).orderStatus == Status.DELIVERED)
                countOfDeliveredOrders++;
            else if (list.get(i).orderStatus == Status.SHIPPED) {
                countOfShippedOrders++;
            }
            if (list.get(i).wasItBoughtWithDiscount) {
                ordersWithDiscount++;
            }
            totalRevenue += list.get(i).paid;
        }
        System.out.println("Delivered orders: " + countOfDeliveredOrders + '\n' +
                "Shipped orders: " + countOfShippedOrders + '\n' +
                "Canceled orders: " + '\n' +
                "Total: " + list.size() + '\n' +
                "Discounted orders: " + ordersWithDiscount + '\n' +
                "Total revenue: " + totalRevenue + '\n' +
                list);
    }

    @Override
    public String toString() {
        return '\n' +
                "ID: " + id + '\n' +
                "OrderNumber: " + OrderNumber + '\n' +
                "BuyersFullName: " + buyersFullName + '\n' +
                "OrderDate: " + orderDate + '\n' +
                "Category: " + category + '\n' +
                "Brand: " + brand + '\n' +
                "ProductName: " + ProductName + '\n' +
                "Price: " + Price + '\n' +
                "Quantity: " + quantity + '\n' +
                "Discount: " + discount + '\n' +
                "Colour: " + colour + '\n' +
                "Paid: " + paid + '\n' +
                "Status: " + orderStatus +
                '\n';
    }

    public void cancelOrder(int id) {
        Order order = getId(id);
        if (order != null) {
            list.remove(order);
            System.out.println("Order canceled successfully.");
        } else {
            System.out.println("Order not found.");
        }
    }

    public void orderShipped() {
        System.out.println("Order is already Shipped");
    }
}

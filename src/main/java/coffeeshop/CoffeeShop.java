package coffeeshop;

import java.util.ArrayList;

// STEP 5 · CoffeeShop: the shop, its menu, and every order it finished today.
//
// Open UML.md and find "Step 5 · CoffeeShop".
//   4 private fields: name, menu, completedOrders, totalSales
//   1 constructor:    CoffeeShop(String name)
//   7 methods:        getName(), getMenu(), checkout(), getOrdersCompleted(),
//                     getTotalSales(), getItemsSold(), salesReport()
//
// Then drag check/coffeeshop/CoffeeShopTest.java into src/test/java/coffeeshop/ and run it.
// Commit message:  step 5: CoffeeShop

public class CoffeeShop {

    private String name;
    private Menu menu;
    private ArrayList<Order> completedOrders;
    private double totalSales;

    // Makes the shop with its name, a menu, no orders yet, and $0 in sales.
    public CoffeeShop(String name){
        this.name = name;
        menu = new Menu();
        completedOrders = new ArrayList<>();
        totalSales = 0;
    }

    // Gives back the name of the shop.
    public String getName(){
        return name;
    }

    // Gives back the shop's menu.
    public Menu getMenu(){
        return menu;
    }

    // Finishes an order: saves it, adds its total to the sales, and gives back the total. An empty order gives back 0.
    public double checkout(Order order, int tipPercent){
        if (order.isEmpty()){
            return 0;
        }
        double total = order.getTotal(tipPercent);
        completedOrders.add(order);
        totalSales += total;
        return total;
    }

    // Gives back how many orders have been checked out today.
    public int getOrdersCompleted(){
        return completedOrders.size();
    }

    // Gives back all the money taken in today.
    public double getTotalSales(){
        return totalSales;
    }

    // Adds up how many items were sold in all the finished orders.
    public int getItemsSold(){
        int count = 0;
        for (Order order : completedOrders){
            count += order.getItemCount();
        }
        return count;
    }

    // Gives back today's sales report: orders, items sold, and the total.
    public String salesReport(){
        String result = name + " - today's sales\n";
        result += "  Orders: " + getOrdersCompleted() + "\n";
        result += "  Items sold: " + getItemsSold() + "\n";
        result += String.format("  Total: $%.2f%n", totalSales);
        return result;
    }
}

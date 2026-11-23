package coffeeshop;

import java.util.ArrayList;

// STEP 4 · Order: one customer's order.
//
// Open UML.md and find "Step 4 · Order". This is the biggest class. Build it one method at a
// time, and run the test after each one.
//   2 constants:      COUPON_CODE, COUPON_PERCENT   (public static final)
//   1 static field:   nextOrderNumber, starts at 1
//   3 private fields: orderNumber, items, discountPercent
//   1 constructor:    Order()
//   10 methods:       getOrderNumber(), addItem(), removeItem(), getItemCount(), isEmpty(),
//                     getSubtotal(), applyCoupon(), getDiscount(), getTotal(), toString()
//
// Then drag check/coffeeshop/OrderTest.java into src/test/java/coffeeshop/ and run it.
// Commit message:  step 4: Order

public class Order {

    public static final String COUPON_CODE = "HORNET10";
    public static final int COUPON_PERCENT = 10;

    private static int nextOrderNumber = 1;
    private int orderNumber;
    private ArrayList<MenuItem> items;
    private int discountPercent;

    // Makes a new empty order and gives it the next order number.
    public Order(){
        this.orderNumber = nextOrderNumber;
        nextOrderNumber += 1;
        items = new ArrayList<>();
        discountPercent = 0;
    }

    // Gives back this order's number.
    public int getOrderNumber(){
        return orderNumber;
    }

    // Adds an item to the order.
    public void addItem(MenuItem item){
        items.add(item);
    }

    // Removes the item with this number (starting at 1). Gives back false if there is no such item.
    public boolean removeItem(int number){
        if (number < 1 || number > items.size()){
            return false;
        }
        items.remove(number - 1);
        return true;
    }

    // Gives back how many items are in the order.
    public int getItemCount(){
        return items.size();
    }

    // Gives back true if the order has no items.
    public boolean isEmpty(){
        return items.isEmpty();
    }

    // Adds up the price of every item in the order.
    public double getSubtotal(){
        double subtotal = 0;
        for (MenuItem item : items){
            subtotal += item.getPrice();
        }
        return subtotal;
    }

    // Gives the coupon discount if the code is right. Gives back true if it worked.
    public boolean applyCoupon(String code){
        // trims both sides of the code of spaces and checks if it equals the coupon
        if (code.trim().equalsIgnoreCase(COUPON_CODE)){
            discountPercent = COUPON_PERCENT;
            return true;
        }
        return false;
    }

    // Gives back how much money the coupon takes off.
    public double getDiscount(){
        return getSubtotal() * discountPercent / 100.0;
    }

    // Takes off the discount, then adds the tip on what is left. A negative tip counts as 0.
    public double getTotal(int tipPercent){
        if (tipPercent < 0){
            tipPercent = 0;
        }
        double afterDiscount = getSubtotal() - getDiscount();
        double tip = afterDiscount * tipPercent / 100.0;
        return afterDiscount + tip;
    }

    // Gives back the order as text: the number, each item, the subtotal, and the discount if it's one.
    public String toString(){
        String result = "Order #" + orderNumber + "\n";
        for (int i = 0; i < items.size(); i++){
            int number = i + 1;
            result += "  " + number + ". " + items.get(i) + "\n";
        }
        result += String.format("  Subtotal: $%.2f%n", getSubtotal());
        if (discountPercent > 0){
            result += String.format("  Discount: -$%.2f%n", getDiscount());
        }
        return result;
    }

}

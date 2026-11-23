# My Shop: Hornet Coffee

Hornet Coffee is a text based game that runs in the console. You play as a customer at a coffee shop: you look at the menu, build an order, use a coupon, check out with a tip, and see the day's sales.

## How to run it

1. Navigate files to search for this filepath `src/main/java/coffeeshop/CoffeeShopApp.java` in IntelliJ.
2. Find the line `public static void main(String[] args)`.
3. Click the green ▶ next to it and pick Run.
4. Type a number from the menu and press Enter. Type `0` to close the shop.

## The 7 classes

| Class | What it does |
|---|---|
| **MenuItem** | One thing you can buy. It has a name and a price, and it is the parent class of **Drink** and **Food**. |
| **Drink** | A **MenuItem** that comes in a size (S, M or L). Medium costs 50 cents more and large costs $1.00 more. |
| **Food** | A **MenuItem** that can be heated up for 50 cents. |
| **Menu** | The list of the 8 things the shop sells. You can get an item by its number, starting at 1. |
| **Order** | One customer's order. It holds the items, adds up the subtotal, applies the `HORNET10` coupon for 10% off, and adds a tip to get the total. Every new order gets the next order number. |
| **CoffeeShop** | The shop has the menu, saves every order that is checked out, and keeps track of the day's sales for the sales report. |
| **CoffeeShopApp** | The game. It has `main` where the program executes and the game loop runs, which shows the main menu, reads what the user types, and does that choice until the user picks 0. |

## One thing that was hard
The toString methods for most of the classes were harder than I expected. I need to refresh my String methods and work with them more from here on out. Order's toString specifically took me a minute. When I set up the method it had no return statement, so it would not compile, and it took me longer than it should have to see why, maybe because I was tired. I got help finishing it, and going through the finished version is how it clicked: the method builds one String piece by piece and then has to return that result at the end. I also learned that items.get(i) automatically calls each item's own toString, so Order does not need to know how to print a Drink or a Food.

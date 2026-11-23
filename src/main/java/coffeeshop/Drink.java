package coffeeshop;

// STEP 2 · Drink: a MenuItem that comes in a size, S, M or L.
//
// Open UML.md and find "Step 2 · Drink extends MenuItem".
// First change the class line below to:   public class Drink extends MenuItem {
// (It does not say "extends" yet, so this file still compiles while you work on Step 1.)
//
//   2 constants:     MEDIUM_UPCHARGE, LARGE_UPCHARGE   (public static final double)
//   1 private field: size
//   1 constructor:   Drink(String name, double price, char size). Its first line is super(name, price);
//   4 methods:       getSize(), and the overrides getPrice(), isDrink(), toString()
//
// Then drag check/coffeeshop/DrinkTest.java into src/test/java/coffeeshop/ and run it.
// Commit message (after Food is green too):  step 2: Drink and Food

public class Drink extends MenuItem {
    public static final double MEDIUM_UPCHARGE = 0.50;
    public static final double LARGE_UPCHARGE = 1.00;
    private char size;

    // Makes a drink. The size is saved as S, M or L, and anything else becomes S.
    public Drink(String name, double price, char size){
        super(name, price);
        char upperCaseSize = Character.toUpperCase(size);
        if (upperCaseSize == 'M' || upperCaseSize == 'L'){
            this.size = upperCaseSize;
        }
        else{
            this.size = 'S';

        }
    }


    // Gives back the size letter of the drink.
    public char getSize(){
        return size;
    }

    // Gives back the price with the size upcharge added.
    public double getPrice(){
        if (size == 'M'){
            return super.getPrice() + MEDIUM_UPCHARGE;
        }
        else if (size == 'L'){
            return super.getPrice() + LARGE_UPCHARGE;
        }
            return super.getPrice();


    }

    // Gives back true, because this is a drink.
    public boolean isDrink(){
        return true;
    }
    // Gives back the drink as text, like "Latte (M) - $3.75".
    public String toString(){
        return String.format("%s (%c) - $%.2f",getName(),size, getPrice());
    }


}

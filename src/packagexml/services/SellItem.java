package packagexml.services;


import java.util.function.ToDoubleBiFunction;

public class SellItem implements PriceCheck {
    @Override
    public String getPrice() {
        return "the item is currently wightless";
        //how to pass the actual item from the db?
    }
    // add set gold here

}

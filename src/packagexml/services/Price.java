package packagexml.services;


public class Price implements PriceCheck {
    @Override
    public String getPrice() {
        return "the item is currently priceless";
        //how to pass the actual item from the db?
    }
}

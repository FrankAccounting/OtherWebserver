package packagexml.services;
import org.springframework.stereotype.Component;



@Component
public class SellItem implements PriceCheck {
    @Override
    public String getPrice() {
        return "the item is currently priceless";
        //how to pass the actual item from the db?
    }
    // add set gold here

}

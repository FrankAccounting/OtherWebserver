package packagexml.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import packagexml.services.PriceCheck;
@Component
public class Gear {
    private int gearid;
    private String name;
    private int dmg;
    private int weight;
    private String geardescrip;
    private int price;
    private int characterID;
    @Autowired
    private PriceCheck priceCheck;


    //No Arg
    public Gear() {
    }

    //One Arg, Seems kinda dumb why did i have to neame
    // this var not to be privecheck?
    public Gear(PriceCheck pc) {
    this.priceCheck = pc;
    }



    public int getGearid() {
        return gearid;
    }

    public void setGearid(int gearid) {
        this.gearid = gearid;
    }


    public String showPriceCheck() {
        return priceCheck.getPrice();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getGeardescrip() {
        return geardescrip;
    }

    public void setGeardescrip(String geardescrip) {
        this.geardescrip = geardescrip;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCharacterID() {
        return characterID;
    }

    public void setCharacterID(int characterID) {
        this.characterID = characterID;
    }
}

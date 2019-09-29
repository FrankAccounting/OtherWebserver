package packagexml.beans;

public class Gear {
    int gearid = this.gearid;
    String name = this.name;
    int dmg = this.dmg;
    int weight = this.weight;
    String geardescrip = this.geardescrip;
    int price = this.price;
    int characterID = this.characterID;

    public Gear() {
    }

    public int getGearid() {
        return gearid;
    }

    public void setGearid(int gearid) {
        this.gearid = gearid;
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

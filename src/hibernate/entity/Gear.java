package hibernate.entity;

import javax.persistence.*;

@Entity
@Table (name = "GEAR")
public class Gear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GEAR_ID")
    private int gearId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DMG")
    private int damage;

    @Column(name = "WEIGHT")
    private int weight;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private int price;

    public Gear() {
    }

    public Gear(String name, int damage, int weight, String description, int price) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }





    @Override
    public String toString() {
        return "Gear{" +
                "gearId=" + gearId +
                ", name='" + name + '\'' +
                ", damage=" + damage +
                ", weight=" + weight +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}



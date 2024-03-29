package hibernate.entity;

import javax.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "GEAR")
public class Gear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GEAR_ID")
    private int gearId;

    @NotNull(message = "Required")
    @Size(min = 1, max = 30,  message = "1-30 characters")
    @Column(name = "NAME")
    private String name;

    @NotNull(message = "Required")
    @Min(value = 1 ,  message = "1-3 characters")
    @Max(value = 100 ,  message = "1-3 characters")
    @Column(name = "DMG")
    private int damage;

    @NotNull(message = "Required")
    @Min(value = 1 ,  message = "1-3 characters")
    @Max(value = 100 ,  message = "1-3 characters")
    private int weight;

    @NotNull
    @Size(min = 1, max = 30,  message = "1-30 characters")
    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull(message = "Required")
    @Min(value = 1 ,  message = "1-3 characters")
    @Max(value = 100 ,  message = "1-3 characters")
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

    public int getID() {
        return gearId;
    }
}



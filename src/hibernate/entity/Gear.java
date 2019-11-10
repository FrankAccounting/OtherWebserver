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

    @Column(name = "CHARACTER_ID")
    private int charaterId;

}



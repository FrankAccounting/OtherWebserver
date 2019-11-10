package hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "GEAR_STORE")

public class GearStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GEAR_ID")
    private int gearId;

    @Column(name = "CHARACTER_ID")
    private int characterId;


}
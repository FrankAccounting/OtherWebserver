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

    public GearStore() {
    }

    public int getGearId() {
        return gearId;
    }

    public void setGearId(int gearId) {
        this.gearId = gearId;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    @Override
    public String toString() {
        return "GearStore{" +
                "gearId=" + gearId +
                ", characterId=" + characterId +
                '}';
    }
}
package hibernate.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "player_character")

public class PlayerCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHARACTER_ID")
    private int characterId;

    @NotNull
    @Size(min = 1, max = 30,  message = "1-30 characters")
    @Column(name = "CHARACTER_NM")
    private String characterNm;

    @NotNull(message = "Required")
    @Size(min = 1, max = 3,  message = "1-3 characters")
    @Column(name = "ALIGN")
    private String alignment;


    @NotNull(message = "Required")
    @Size(min = 1, max = 7,  message = "1-7 characters")
    @Column(name = "XP")
    private int xp;

    @NotNull(message = "Required")
    @Size(min = 1, max = 30,  message = "1-30 characters")
    @Column(name = "MONEY")
    private int money;

    @NotNull(message = "Required")
    @Size(min = 1, max = 2,  message = "1-2 characters")
    @Column(name = "AGILITY")
    private int agility;

    @NotNull(message = "Required")
    @Size(min = 1, max = 2,  message = "1-2 characters")
    @Column(name = "SMARTS")
    private int smarts;

    @NotNull(message = "Required")
    @Size(min = 1, max = 2,  message = "1-2 characters")
    @Column(name = "SPIRIT")
    private int spirit;

    @NotNull(message = "Required")
    @Size(min = 1, max = 2,  message = "1-2 characters")
    @Column(name = "STRENGTH")
    private int strength;

    @NotNull(message = "Required")
    @Size(min = 1, max = 2,  message = "1-2 characters")
    @Column(name = "VIGOR")
    private int vigor;

    @Column(name = "Picture")
    private String picture;


    @NotNull
    @Size(min = 1, max = 30,  message = "1-30 characters")
    @Column(name = "Description")
    private String Description;

    public PlayerCharacter() {
    }


    @ManyToMany(cascade = CascadeType.ALL)

    // I choose many to many because many columns in the "gear table" need to map with many items in the "character id" table.
    // I chose to cascade all becasue when player charcters are deleted they should also be deleted from the
    // the gear store, if not the ID's would liger after deletion
    @JoinTable(name="GEAR_STORE",
            joinColumns = @JoinColumn(name="CHARACTER_ID"),
            inverseJoinColumns = @JoinColumn(name="GEAR_ID"))
    private List<Gear> gearList;

    public void add(Gear tempGear){
        if (tempGear == null)
            gearList = new ArrayList<>();
        gearList.add(tempGear);
    }

    public List<Gear> getGearList() {
        return gearList;
    }

    public void setGearList(List<Gear> gearList) {
        this.gearList = gearList;
    }

    public PlayerCharacter(String characterNm, String alignment, int xp, int money, int agility, int smarts, int spirit, int strength, int vigor, String picture, String description) {
        this.characterNm = characterNm;
        this.alignment = alignment;
        this.xp = xp;
        this.money = money;
        this.agility = agility;
        this.smarts = smarts;
        this.spirit = spirit;
        this.strength = strength;
        this.vigor = vigor;
        this.picture = picture;
        Description = description;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public String getCharacterNm() {
        return characterNm;
    }

    public void setCharacterNm(String characterNm) {
        this.characterNm = characterNm;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getSmarts() {
        return smarts;
    }

    public void setSmarts(int smarts) {
        this.smarts = smarts;
    }

    public int getSpirit() {
        return spirit;
    }

    public void setSpirit(int spirit) {
        this.spirit = spirit;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getVigor() {
        return vigor;
    }

    public void setVigor(int vigor) {
        this.vigor = vigor;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "PlayerCharacter{" +
                "characterId=" + characterId +
                ", characterNm='" + characterNm + '\'' +
                ", alignment='" + alignment + '\'' +
                ", xp=" + xp +
                ", money=" + money +
                ", agility=" + agility +
                ", smarts=" + smarts +
                ", spirit=" + spirit +
                ", strength=" + strength +
                ", vigor=" + vigor +
                ", picture='" + picture + '\'' +
                ", Description='" + Description + '\'' +
                ", gearList=" + gearList.size() +
                '}';
    }
}

package hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "player_character")

public class PlayerCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHARACTER_ID")
    private int characterId;

    @Column(name = "CHARACTER_NM")
    private String characterNm;

    @Column(name = "ALIGN")
    private String alignment;

    @Column(name = "XP")
    private int xp;

    @Column(name = "MONEY")
    private int money;

    @Column(name = "AGILITY")
    private int agility;

    @Column(name = "SMARTS")
    private int smarts;

    @Column(name = "SPIRIT")
    private int spirit;

    @Column(name = "STRENGTH")
    private int strength;

    @Column(name = "VIGOR")
    private int vigor;

    @Column(name = "Picture")
    private String picture;

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

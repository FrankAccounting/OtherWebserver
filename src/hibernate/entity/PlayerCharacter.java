package hibernate.entity;

import javax.persistence.*;

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





}

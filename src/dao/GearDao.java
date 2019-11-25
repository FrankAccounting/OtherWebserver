package dao;

import hibernate.entity.Gear;

import java.util.List;

public interface GearDao {
    void createGear (Gear gear);
    List<Gear> listGear();
    void deleteGear(int ID);
    Gear getGear(int ID);
    void updateGear(Gear gear);

}



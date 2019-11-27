package dao;

import hibernate.entity.Gear;

import java.util.List;

public interface GearDao {
    Gear getGear(int theID);
    void createGear (Gear gear);
    List<Gear> listGear();
    void deleteGear(int ID);
    void updateGear(Gear gear);

}



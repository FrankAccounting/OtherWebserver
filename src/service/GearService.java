package service;

import hibernate.entity.Gear;

import java.util.List;

public interface GearService {
    void createGear (Gear gear);
    List<Gear> listGear();
    void deleteGear(int theID);
    Gear getGear(int theID);
    void updateGear(Gear gear);

    List<Gear> getGearByName(String theSeachTerm);
}



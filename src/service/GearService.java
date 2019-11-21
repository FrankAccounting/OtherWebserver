package service;

import hibernate.entity.Gear;

public interface GearService {
    void createGear (Gear gear);
    public void listGear(Gear gear);
    public void deleteGear(Gear gear);
    public void updateGear(Gear gear);
    Gear getGear(int ID);


}

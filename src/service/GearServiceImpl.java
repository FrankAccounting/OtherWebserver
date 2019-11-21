package service;
import dao.GearDao;
import hibernate.entity.Gear;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GearServiceImpl implements GearService {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void createGear(Gear gear) {
            Session session = sessionFactory.getCurrentSession();
            session.save(gear);
        }
    public Gear getGear(int ID){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Gear.class, ID);
    }


    public void listGear(Gear gear) {
        Session session = sessionFactory.getCurrentSession();
        List<Gear> allGear = session.createQuery("from Gear",Gear.class).getResultList();
        System.out.print(allGear.iterator());
    }

    public void deleteGear(Gear gear) {
        Session session = sessionFactory.getCurrentSession();
        Gear aPeiceOfGear = session.get(Gear.class, 1);

        if (aPeiceOfGear != null)
            session.delete(aPeiceOfGear);
    }

    public void updateGear(Gear gear) {
        Session session = sessionFactory.getCurrentSession();
        Gear aPeiceOfGear = session.get(Gear.class, 1);
        if (aPeiceOfGear != null)
            aPeiceOfGear.setDescription(aPeiceOfGear.getDescription() + "it worked");
    }



}


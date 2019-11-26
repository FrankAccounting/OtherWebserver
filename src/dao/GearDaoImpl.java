package dao;
import hibernate.entity.Gear;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GearDaoImpl implements GearDao {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void createGear(Gear gear) {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(gear);
        }

    @Override
    public Gear getGear(int theID){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Gear.class, theID);
    }


    public List<Gear>listGear() {
        Session session = sessionFactory.getCurrentSession();
        List<Gear> allGear = session.createQuery("from Gear",Gear.class).getResultList();

        System.out.print(allGear.iterator());

        return allGear;
    }

    public void deleteGear(int ID) {
        Session session = sessionFactory.getCurrentSession();
        Gear aPeiceOfGear = session.get(Gear.class, ID);

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


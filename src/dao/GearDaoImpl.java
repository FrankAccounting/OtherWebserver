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
            session.save(gear);
        }

    private void listGear(Gear gear) {
        Session session = sessionFactory.getCurrentSession();
        List<Gear> allGear = session.createQuery("from Gear").getResultList();
        System.out.print(allGear.iterator());
    }

    private void deleteGear(Gear gear) {
        Session session = sessionFactory.getCurrentSession();
        Gear aPeiceOfGear = session.get(Gear.class, 1);

        if (aPeiceOfGear != null)
            session.delete(aPeiceOfGear);
    }

    private void updateGear(Gear gear) {
        Session session = sessionFactory.getCurrentSession();
        Gear aPeiceOfGear = session.get(Gear.class, 1);
        if (aPeiceOfGear != null)
            aPeiceOfGear.setDescription(aPeiceOfGear.getDescription() + "it worked");
    }



}


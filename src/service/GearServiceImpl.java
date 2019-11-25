package service;
import dao.GearDao;
import hibernate.entity.Gear;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class GearServiceImpl implements GearService {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @Transactional
    public void createGear(Gear gear) {
        Session session = sessionFactory.getCurrentSession();
        session.save(gear);
    }
    @Transactional
    public Gear getGear(int ID){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Gear.class, ID);
    }

    @Transactional
    public List<Gear>listGear() {
        Session session = sessionFactory.getCurrentSession();
        List<Gear> allGear = session.createQuery("from Gear",Gear.class).getResultList();
        System.out.print(allGear.iterator());

        return allGear;
    }
    @Transactional
    public void deleteGear(int ID) {
        Session session = sessionFactory.getCurrentSession();
        Gear aPeiceOfGear = session.get(Gear.class, ID);

        if (aPeiceOfGear != null)
            session.delete(aPeiceOfGear);
    }
    @Transactional
    public void updateGear(Gear gear) {
        Session session = sessionFactory.getCurrentSession();
        Gear aPeiceOfGear = session.get(Gear.class, 1);
        if (aPeiceOfGear != null)
            aPeiceOfGear.setDescription(aPeiceOfGear.getDescription() + "it worked");
    }



}

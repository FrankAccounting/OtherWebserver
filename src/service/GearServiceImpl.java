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
    private GearDao gearDao;
    @Override
    @Transactional
    public void createGear(Gear gear) {
        gearDao.createGear(gear);
    }

    @Override
    @Transactional
    public Gear getGear(int theId) {
        return gearDao.getGear(theId);

    }

    @Override
    public void updateGear(Gear gear) {

    }


    @Transactional
    public List<Gear>listGear() {
        return gearDao.listGear();
    }

    @Transactional
    public void deleteGear(int ID) {
        gearDao.deleteGear(ID);
    }





}

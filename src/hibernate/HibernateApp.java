package hibernate;

import hibernate.entity.Gear;
import hibernate.entity.GearStore;
import hibernate.entity.PlayerCharacter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateApp {
    private SessionFactory factory;

    public HibernateApp() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Gear.class)
                .addAnnotatedClass(GearStore.class)
                .addAnnotatedClass(PlayerCharacter.class)
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        HibernateApp newApp = new HibernateApp();

        try {
            HibernateApp.createPlayerAndGear();
        } finally {
            demo.close();
        }
    }

    private void createPlayerAndGear() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();





    }


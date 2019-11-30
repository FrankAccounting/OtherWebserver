package hibernate;

import hibernate.entity.Gear;
import hibernate.entity.GearStore;
import hibernate.entity.PlayerCharacter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateApp {
    private SessionFactory factory;

    public HibernateApp() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Gear.class)
                .addAnnotatedClass(GearStore.class)
                .addAnnotatedClass(PlayerCharacter.class)
                .buildSessionFactory();
    }


    public void close() {
        factory.close();
    }


    public static void main(String[] args) {
        HibernateApp newSessionApp = new HibernateApp();

        try {
//            int id = newSessionApp.createPlayer();
//            int gid = newSessionApp.createGear();
////            newSessionApp.createGearStore();
//            newSessionApp.listPlayers();
////            newSessionApp.listGearStore();
//            newSessionApp.listGear();
//            newSessionApp.updateGear(gid);    //  Breaks :c    Forein Key error
//            newSessionApp.updatePlayers(id);
////            newSessionApp.updateGearStore();   //Runs but does not update
//            newSessionApp.deleteGear(gid);    //breaks   Forein Key error
////            newSessionApp.deleteGearStore();
//            newSessionApp.deletePlayer(id);   //Forein Key error

            int id = newSessionApp.createPlayersWithGear();
            newSessionApp.deletePlayer(id);

        } finally {
            newSessionApp.close();
        }
    }

    private int createPlayer() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        PlayerCharacter frank = new PlayerCharacter("Frank", "NG", 1, 1, 1, 1, 1, 1, 1, "frank.jpeg", "accountant");

        session.save(frank);

        session.getTransaction().commit();

        return frank.getCharacterId();
    }

    private int createPlayersWithGear() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        PlayerCharacter tetsuo = new PlayerCharacter("Tetsuo", "TN", 1, 1, 1, 1, 1, 1, 1, "frank.jpeg", "accountant");
        PlayerCharacter kaneda = new PlayerCharacter("Kaneda", "CG", 1, 1, 1, 1, 1, 1, 1, "frank.jpeg", "accountant");

        Gear teddyBear = new Gear("Teddy Bear", 1, 1, "A creepy melting bear", 1);
        session.save(teddyBear);
        Gear motorcycle = new Gear("Motorcycle", 1, 1, "Fit for a bike gang leader", 1);
        session.save(motorcycle);

        tetsuo.add(teddyBear);
        kaneda.add(teddyBear);
        kaneda.add(motorcycle);

        session.save(tetsuo);
        session.save(kaneda);

        session.getTransaction().commit();

        return tetsuo.getCharacterId();
    }



    private int createGear() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Gear pen = new Gear("pen", 1, 1, "A pointy object", 1);

        session.save(pen);

        session.getTransaction().commit();

        return pen.getID();
    }


    private int createGearStore() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        GearStore inventoryKeeper = new GearStore(1);

        session.save(inventoryKeeper);

        session.getTransaction().commit();

        return inventoryKeeper.getGearId();
    }



    private List<PlayerCharacter> listPlayers() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        List<PlayerCharacter> allPlayers = session.createQuery("from PlayerCharacter").getResultList();

        for (PlayerCharacter pc : allPlayers){
            System.out.print(pc);
        }


        System.out.print(allPlayers.iterator());

        session.getTransaction().commit();

        return allPlayers;
    }

    private void listGear() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Gear> allGear = session.createQuery("from Gear").getResultList();


        System.out.print(allGear.iterator());

        session.getTransaction().commit();
    }

    private void listGearStore() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        List<GearStore> allStores = session.createQuery("from GearStore").getResultList();

        System.out.print(allStores.iterator());
        session.getTransaction().commit();
    }

    private void updatePlayers(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        PlayerCharacter aPlayerCharacter = session.get(PlayerCharacter.class, id);

        if (aPlayerCharacter != null)
            aPlayerCharacter.setDescription(aPlayerCharacter.getDescription() + "it worked");

        session.getTransaction().commit();
    }


    private void updateGear(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Gear aPeiceOfGear = session.get(Gear.class, id);

        if (aPeiceOfGear != null)
            aPeiceOfGear.setDescription(aPeiceOfGear.getDescription() + "it worked");

        session.getTransaction().commit();
    }

    private void updateGearStore() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        GearStore updateGearStore = session.get(GearStore.class, 1);

        if (updateGearStore != null)
            updateGearStore.setGearId(1);

        session.getTransaction().commit();
    }

    private void deletePlayer(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        PlayerCharacter aPlayerCharacter = session.get(PlayerCharacter.class, id);

        if (aPlayerCharacter != null)
            session.delete(aPlayerCharacter);

        session.getTransaction().commit();
    }

    private void deleteGear(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Gear aPeiceOfGear = session.get(Gear.class, id);

        if (aPeiceOfGear != null)
            session.delete(aPeiceOfGear);

        session.getTransaction().commit();
    }

    private void deleteGearStore() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        GearStore updateGearStore = session.get(GearStore.class, 1);

        if (updateGearStore != null)
            session.delete(updateGearStore);

        session.getTransaction().commit();
    }


    }


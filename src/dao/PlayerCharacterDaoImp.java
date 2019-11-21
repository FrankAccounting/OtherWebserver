package dao;

import hibernate.entity.PlayerCharacter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
    public class PlayerCharacterDaoImp implements PlayerCharacterDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createPlayer(PlayerCharacter playerCharacter) {
        Session session = sessionFactory.getCurrentSession();
        session.save(playerCharacter);
    }

    public PlayerCharacter getPlayerCharacter(int ID){
        Session session = sessionFactory.getCurrentSession();
        return session.get(PlayerCharacter.class, ID);
    }

    public List<PlayerCharacter> listPlayers() {
        Session session = sessionFactory.getCurrentSession();
        List<PlayerCharacter> allPlayers = session.createQuery("from PlayerCharacter",PlayerCharacter.class).getResultList();

        for (PlayerCharacter pc : allPlayers) {
            System.out.print(pc);
        }

        return allPlayers;
    }

    public void deletePlayer(int ID) {
        Session session = sessionFactory.getCurrentSession();
        PlayerCharacter aPlayerCharacter = session.get(PlayerCharacter.class, ID);

        if (aPlayerCharacter != null)
            session.delete(aPlayerCharacter);
    }

    public void updatePlayers(PlayerCharacter playerCharacter) {
        Session session = sessionFactory.getCurrentSession();

        PlayerCharacter aPlayerCharacter = session.get(PlayerCharacter.class, 1);

        if (aPlayerCharacter != null)
            aPlayerCharacter.setDescription(aPlayerCharacter.getDescription() + "it worked");

    }
}

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

        private void listPlayers() {
            Session session = sessionFactory.getCurrentSession();
            List<PlayerCharacter> allPlayers = session.createQuery("from PlayerCharacter").getResultList();

            for (PlayerCharacter pc : allPlayers) {
                System.out.print(pc);
            }
        }

            private void deletePlayer() {
                Session session = sessionFactory.getCurrentSession();
                PlayerCharacter aPlayerCharacter = session.get(PlayerCharacter.class, 1);

                if (aPlayerCharacter != null)
                    session.delete(aPlayerCharacter);
            }


            private void updatePlayers() {
                Session session = factory.getCurrentSession();

                PlayerCharacter aPlayerCharacter = session.get(PlayerCharacter.class, 1);

                if (aPlayerCharacter != null)
                    aPlayerCharacter.setDescription(aPlayerCharacter.getDescription() + "it worked");

            }


    }


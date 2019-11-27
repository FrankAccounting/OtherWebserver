package service;

import dao.PlayerCharacterDao;
import hibernate.entity.PlayerCharacter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
    public class PlayerCharacterServiceImp implements PlayerCharacterService {
        @Autowired
        private SessionFactory sessionFactory;

        @Override
        @Transactional
        public void createPlayer(PlayerCharacter playerCharacter) {
            Session session = sessionFactory.getCurrentSession();
            session.save(playerCharacter);
        }


        @Transactional
        public PlayerCharacter getPlayerCharacter(int ID){
            Session session = sessionFactory.getCurrentSession();

            return session.get(PlayerCharacter.class,ID);
        }

        @Transactional
        public List<PlayerCharacter> listPlayers() {
            Session session = sessionFactory.getCurrentSession();
            List<PlayerCharacter> allPlayers = session.createQuery("from PlayerCharacter", PlayerCharacter.class).getResultList();
            System.out.print(allPlayers.iterator());
            return allPlayers;
        }

        @Transactional
        public void deletePlayer(int ID) {
            Session session = sessionFactory.getCurrentSession();
            PlayerCharacter aPlayerCharacter = session.get(PlayerCharacter.class,ID);

            if (aPlayerCharacter != null)
                session.delete(aPlayerCharacter);
            }

        @Transactional
        public void updatePlayers(PlayerCharacter playerCharacter) {
            Session session = sessionFactory.getCurrentSession();
            PlayerCharacter aPlayerCharacter = session.get(PlayerCharacter.class,1);

            if (aPlayerCharacter != null)
                aPlayerCharacter.setDescription(aPlayerCharacter.getDescription() + "it worked again");
            }
    }
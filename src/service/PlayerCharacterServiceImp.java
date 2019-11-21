package service;

import dao.PlayerCharacterDao;
import hibernate.entity.PlayerCharacter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
    public class PlayerCharacterServiceImp implements PlayerCharacterService {
        @Autowired
        private PlayerCharacterDao aPlayerCharacterDao;

        @Override
        public void createPlayer(PlayerCharacter playerCharacter) {
            aPlayerCharacterDao.createPlayer(playerCharacter);
        }

        public PlayerCharacter getPlayerCharacter(int ID){
            return aPlayerCharacterDao.getPlayerCharacter(ID);
        }

        public List<PlayerCharacter> listPlayers() {
            return aPlayerCharacterDao.listPlayers();
        }

        public void deletePlayer(int ID) {
            aPlayerCharacterDao.deletePlayer(ID);
            }

         public void updatePlayers(PlayerCharacter playerCharacter) {
            aPlayerCharacterDao.updatePlayers(playerCharacter);
            }
    }


package dao;

import hibernate.entity.PlayerCharacter;

import java.util.List;

public interface PlayerCharacterDao {
    void createPlayer(PlayerCharacter playerCharacter);
    List<PlayerCharacter> listPlayers();
    void deletePlayer(int ID);
    void updatePlayers(PlayerCharacter playerCharacter);
    PlayerCharacter getPlayerCharacter(int ID);
}

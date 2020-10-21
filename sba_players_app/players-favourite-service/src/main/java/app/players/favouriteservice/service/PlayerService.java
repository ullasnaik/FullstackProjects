package app.players.favouriteservice.service;

import app.players.favouriteservice.exception.PlayerNotFoundException;
import app.players.favouriteservice.entity.Player;

import java.util.List;

public interface PlayerService {

    Player addNewPlayer(Player player);

    List<Player> listAllPlayers();

    List<Player> listAllPlayersByUserId(String userId);

    Player getPlayerByCode(String playerCode) throws PlayerNotFoundException;

}

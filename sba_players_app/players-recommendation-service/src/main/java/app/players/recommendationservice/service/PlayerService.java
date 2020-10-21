package app.players.recommendationservice.service;

import app.players.recommendationservice.entity.Player;
import app.players.recommendationservice.exception.PlayerNotFoundException;

import java.util.List;

public interface PlayerService {

    List<Player> listAllPlayers();

    Player getPlayerByPlayerId(String ticketId) throws PlayerNotFoundException;

    Player updatePlayer(Player ticket) throws PlayerNotFoundException;
}

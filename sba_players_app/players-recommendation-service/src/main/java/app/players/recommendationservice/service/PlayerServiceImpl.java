package app.players.recommendationservice.service;

import app.players.recommendationservice.exception.PlayerNotFoundException;
import app.players.recommendationservice.entity.Player;
import app.players.recommendationservice.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    private RestTemplate restTemplate;

    private ResponseEntity responseEntity;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, RestTemplate restTemplate) {
        this.playerRepository = playerRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Player> listAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayerByPlayerId(String playerId) throws PlayerNotFoundException {
        if (playerRepository.findById(playerId).isEmpty()) {
            throw new PlayerNotFoundException();
        }
        return playerRepository.findById(playerId).get();
    }

    @Override
    public Player updatePlayer(Player player) throws PlayerNotFoundException {
        if (playerRepository.findById(player.getPid()).isEmpty()) {
            throw new PlayerNotFoundException();
        }
        return playerRepository.save(player);
    }

}

package app.players.favouriteservice.service;

import app.players.favouriteservice.exception.PlayerNotFoundException;
import app.players.favouriteservice.entity.Player;
import app.players.favouriteservice.repository.PlayerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, KafkaTemplate<String, String> kafkaTemplate) {
        this.playerRepository = playerRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public Player addNewPlayer(Player player) {
        Player newPlayer = playerRepository.save(player);
        try {
            kafkaTemplate.send("player-recommend", new ObjectMapper().writeValueAsString(player));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return newPlayer;
    }

    @Override
    public List<Player> listAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> listAllPlayersByUserId(String userId) {
        return playerRepository.findByUserId(userId);
    }

    @Override
    public Player getPlayerByCode(String playerCode) throws PlayerNotFoundException {
        if (playerRepository.findById(playerCode).isEmpty()) {
            throw new PlayerNotFoundException();
        }
        return playerRepository.findById(playerCode).get();
    }

}


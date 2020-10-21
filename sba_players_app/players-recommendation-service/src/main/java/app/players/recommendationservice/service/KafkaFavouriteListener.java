package app.players.recommendationservice.service;

import app.players.recommendationservice.entity.Player;
import app.players.recommendationservice.repository.PlayerRepository;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaFavouriteListener implements FavouriteListener {

    private PlayerRepository playerRepository;

    @Autowired
    public KafkaFavouriteListener(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @KafkaListener(topics = "player-recommend")
    @Override
    public void addNewPlayer(String pString) {
        Player player= new Player();
        try {
            JSONObject jsonObject= new JSONObject(pString);
            player.setPid(jsonObject.getString("pid"));
            player.setName(jsonObject.getString("name"));
            player.setFullName(jsonObject.getString("fullName"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        playerRepository.save(player);
    }
}

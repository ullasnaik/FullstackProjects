package app.players.recommendationservice.controller;

import app.players.recommendationservice.entity.Player;
import app.players.recommendationservice.exception.PlayerNotFoundException;
import app.players.recommendationservice.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")

public class PlayerController {
    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> listAllPlayers() {
        return new ResponseEntity<>(playerService.listAllPlayers(), HttpStatus.OK);
    }

    @GetMapping("/player/{playerId}")
    public ResponseEntity<?> getPlayer(@PathVariable String playerId) throws PlayerNotFoundException {

        return new ResponseEntity<>(playerService.getPlayerByPlayerId(playerId), HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<?> updatePlayer(@RequestBody Player player) throws PlayerNotFoundException {
        return new ResponseEntity<>(playerService.updatePlayer(player), HttpStatus.OK);
    }


}


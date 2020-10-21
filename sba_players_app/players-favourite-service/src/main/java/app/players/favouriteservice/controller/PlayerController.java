package app.players.favouriteservice.controller;

import app.players.favouriteservice.entity.Player;
import app.players.favouriteservice.exception.PlayerNotFoundException;
import app.players.favouriteservice.service.PlayerService;
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

    @GetMapping("/getAll/{userId}")
    public ResponseEntity<?> listAllPlayersByUserId(@PathVariable String userId) {
        return new ResponseEntity<>(playerService.listAllPlayersByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/player/{playerCode}")
    public ResponseEntity<?> getPlayerByCode(@PathVariable String playerCode) throws PlayerNotFoundException {
        return new ResponseEntity<>(playerService.getPlayerByCode(playerCode), HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<?> addNewPlayer(@RequestBody Player player) {
        return new ResponseEntity<>(playerService.addNewPlayer(player), HttpStatus.CREATED);
    }

}

package com.br.elton.observability.adapter.controller;

import com.br.elton.observability.config.Path;
import com.br.elton.observability.domain.model.GameResponse;
import com.br.elton.observability.domain.model.GameWithConsoleResponse;
import com.br.elton.observability.application.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping(Path.API)
public class GameController {

    private static final Logger log = LoggerFactory.getLogger(GameController.class);

    @Autowired
    private GameService gameService;

    @RequestMapping(value = Path.GAMES, method = RequestMethod.GET)
    public ResponseEntity<List<GameWithConsoleResponse>> getAllGames() {
        log.info("Execute Find all");
        return ResponseEntity.ok(gameService.getAllGames());
    }

    @RequestMapping(value = Path.CONSOLE_GAMES, method = RequestMethod.GET)
    public ResponseEntity<List<GameResponse>> getAllGamesByConsole(@PathVariable("id") Long id) throws Exception {
        log.info("Get game By Id: " + id);
        List<GameResponse> games = gameService.getAllGamesByConsole(id);
        if (games.isEmpty()) {
            throw new Exception(" Result is empty");
        } else {
            return ResponseEntity.ok(gameService.getAllGamesByConsole(id));
        }
    }

    @RequestMapping(value = Path.GAMES, method = RequestMethod.POST)
    public ResponseEntity<GameWithConsoleResponse> saveGame(@RequestBody GameWithConsoleResponse gameWithConsoleResponse) {
        log.info("Save new GameWithConsoleResponse: " + gameWithConsoleResponse);
        return ResponseEntity.ok(gameService.saveGame(gameWithConsoleResponse));
    }

}

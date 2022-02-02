package com.br.elton.observability.adapter.controller;

import com.br.elton.observability.config.CustomMetrics;
import com.br.elton.observability.config.Path;
import com.br.elton.observability.domain.model.ConsoleResponse;
import com.br.elton.observability.application.service.ConsoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Path.API)
public class ConsoleController {

    private static final Logger log = LoggerFactory.getLogger(ConsoleController.class);

    @Autowired
    private ConsoleService consoleService;

    @Autowired
    private CustomMetrics customMetrics;

    @RequestMapping(value = Path.CONSOLE_SINGLE, method = RequestMethod.GET)
    public ResponseEntity<ConsoleResponse> getConsoleById(@PathVariable("id") Long id) {
        log.info("Get console By Id: " + id);

        customMetrics.insertCustomMetrics("getConsoleById", "getConsoleById_for_consoles");
        return ResponseEntity.ok(consoleService.getConsole(id));
    }

    @RequestMapping(value = Path.CONSOLES, method = RequestMethod.GET)
    public ResponseEntity<List<ConsoleResponse>> getAllConsoles() {
        customMetrics.insertCustomMetrics("getAllConsoles", "getAllConsoles_for_consoles");
        return ResponseEntity.ok(consoleService.getAllConsoles());
    }

    @RequestMapping(value = Path.CONSOLES, method = RequestMethod.POST)
    public ResponseEntity<ConsoleResponse> saveConsole(@RequestBody ConsoleResponse consoleResponse) {
        log.info("Save new ConsoleResponse: " + consoleResponse);
        return ResponseEntity.ok(consoleService.saveConsole(consoleResponse));
    }

}

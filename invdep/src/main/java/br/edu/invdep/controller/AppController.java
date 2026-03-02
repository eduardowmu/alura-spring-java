package br.edu.invdep.controller;

import br.edu.invdep.service.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {
    @Autowired
    private ValidatorService validatorService;

    @GetMapping("/{entity}")
    public ResponseEntity validators(@PathVariable("entity") String entity) {
        return ResponseEntity.ok(this.validatorService.list(entity));
    }
}
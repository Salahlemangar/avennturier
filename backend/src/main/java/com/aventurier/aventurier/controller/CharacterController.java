package com.aventurier.aventurier.controller;

import com.aventurier.aventurier.model.CharacterMovementRequest;
import com.aventurier.aventurier.model.Coordinate;
import com.aventurier.aventurier.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/character")
public class CharacterController {

    @Autowired
    private CharacterService characterService;


    @PostMapping("/move")
    public ResponseEntity<Coordinate> moveCharacter(@RequestBody CharacterMovementRequest request) {
        Coordinate newCoordinates = characterService.moveCharacter(request.getInitialCoordinates(), request.getMovements());
        return ResponseEntity.ok(newCoordinates);
    }
}

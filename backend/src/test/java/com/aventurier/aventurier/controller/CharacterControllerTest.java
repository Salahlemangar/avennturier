package com.aventurier.aventurier.controller;

import com.aventurier.aventurier.model.CharacterMovementRequest;
import com.aventurier.aventurier.model.Coordinate;
import com.aventurier.aventurier.service.CharacterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class CharacterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CharacterService characterService;

    @InjectMocks
    private CharacterControllerTest characterController;

    @Test
    public void testMoveCharacter() throws Exception {
        Coordinate newCoordinates = new Coordinate(9, 2);
        CharacterMovementRequest request = new CharacterMovementRequest(new Coordinate(3, 0), "SSSSEEEEEENN");

        Mockito.when(characterService.moveCharacter(Mockito.any(Coordinate.class), Mockito.anyString()))
                .thenReturn(newCoordinates);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/character/move")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.x").value(9))
                .andExpect(MockMvcResultMatchers.jsonPath("$.y").value(2));
    }

    // Méthode utilitaire pour convertir un objet en JSON
    private String asJsonString(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
}

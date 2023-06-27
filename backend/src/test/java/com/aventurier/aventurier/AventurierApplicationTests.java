package com.aventurier.aventurier;

import com.aventurier.aventurier.model.Coordinate;
import com.aventurier.aventurier.service.CharacterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AventurierApplicationTests {

	@Autowired
	private CharacterService characterService;

	@Test
	public void testMoveCharacter() {
		// Define the initial coordinates and movements
		Coordinate initialCoordinates = new Coordinate(3, 0);
		String movements = "SSSSEEEEEENN";

		// Execute the moveCharacter method
		Coordinate result = characterService.moveCharacter(initialCoordinates, movements);

		// Verify the result
		assertEquals(9, result.getX());
		assertEquals(2, result.getY());
	}


}

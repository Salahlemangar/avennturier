package com.aventurier.aventurier.model;

public class CharacterMovementRequest {
    private Coordinate initialCoordinates;
    private String movements;

    public CharacterMovementRequest(Coordinate initialCoordinates, String movements) {
        this.initialCoordinates = initialCoordinates;
        this.movements = movements;
    }

    public Coordinate getInitialCoordinates() {
        return initialCoordinates;
    }

    public void setInitialCoordinates(Coordinate initialCoordinates) {
        this.initialCoordinates = initialCoordinates;
    }

    public String getMovements() {
        return movements;
    }

    public void setMovements(String movements) {
        this.movements = movements;
    }
}

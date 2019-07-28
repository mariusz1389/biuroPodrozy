package pl.mazur.omernik.biuropodrozy.tripHandling;

import lombok.Getter;

@Getter
public enum TripType {

    LASTMINUTE("lastminute", false), NORMAL("normal", false), EARLYBIRD("eralybird", true);

    private String type;
    private boolean promotion;

    TripType(String type,boolean promotion) {

        this.type = type;
        this.promotion = promotion;
    }
}

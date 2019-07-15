package pl.mazur.omernik.biuropodrozy.trip;

public class TripExistsException extends RuntimeException {

    public TripExistsException(String message) {
        super(message);
    }
}

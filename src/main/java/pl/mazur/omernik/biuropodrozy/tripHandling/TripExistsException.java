package pl.mazur.omernik.biuropodrozy.tripHandling;

public class TripExistsException extends RuntimeException {

    public TripExistsException(String message) {
        super(message);
    }
}

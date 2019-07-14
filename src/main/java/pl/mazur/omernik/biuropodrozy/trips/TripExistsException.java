package pl.mazur.omernik.biuropodrozy.trips;

public class TripExistsException extends RuntimeException {

    public TripExistsException(String message) {
        super(message);
    }
}

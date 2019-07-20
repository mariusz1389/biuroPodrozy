package pl.mazur.omernik.biuropodrozy.model.user;

public class UserExistsException extends RuntimeException{

    public UserExistsException(String message){
        super(message);
    }
}

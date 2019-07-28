package pl.mazur.omernik.biuropodrozy.tripHandling.database;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataTablesOrder {


    public enum Direction {
        asc, desc
    }

    private Integer column;
    private Direction dir;



}
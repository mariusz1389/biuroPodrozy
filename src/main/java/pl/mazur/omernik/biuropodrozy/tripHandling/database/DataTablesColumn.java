package pl.mazur.omernik.biuropodrozy.tripHandling.database;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataTablesColumn {

    private String name;
    private boolean searchable;
    private boolean orderable;
    private DataTablesSearch search;
}
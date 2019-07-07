package pl.mazur.omernik.biuropodrozy.trips;

import lombok.Getter;

@Getter
public enum ProductType {

    BOOK("książka", false), PRESS("prasa", false), EBOOK("ebook", true);

    private String type;
    private boolean electronic;

    ProductType(String type,boolean electronic) {

        this.type = type;
        this.electronic = electronic;
    }
}

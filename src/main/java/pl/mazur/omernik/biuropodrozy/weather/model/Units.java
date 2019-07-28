package pl.mazur.omernik.biuropodrozy.weather.model;


public enum Units {
    SI(null),
    METRIC("metric"),
    IMPERIAL("imperial");

    private final String value;

    Units(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

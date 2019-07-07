package pl.mazur.omernik.biuropodrozy.categories;

public interface CategoryWithParentCatIdInfoHolder extends CategoryInfoHolder {
    void setParentCatId(String id);
    String getParentCatId();
}

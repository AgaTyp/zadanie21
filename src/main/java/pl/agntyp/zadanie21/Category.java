package pl.agntyp.zadanie21;

public enum Category {
    DOMOWE("Art. gosp. domowego"),
    SPOŻYWCZE("Art. spożywcze"),
    INNE("Inne"),
    WSZYSTKO("Wszystkie produkty");

    private final String description;

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Category fromDescription(String description) {
        Category[] values = values();
        for (Category category : values) {
            if (category.getDescription().equals(description)) {
                return category;
            }
        }
        return null;
    }
}

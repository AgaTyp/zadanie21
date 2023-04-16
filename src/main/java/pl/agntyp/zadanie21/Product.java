package pl.agntyp.zadanie21;

public class Product {
    private String name;
    private Category kategoria;
    private double price;

    public Product() {
    }

    public Product(String name, Category category, double price) {
        this.name = name;
        this.kategoria = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return kategoria;
    }

    public void setCategory(Category category) {
        this.kategoria = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

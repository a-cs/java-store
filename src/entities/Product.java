package entities;

public class Product {

    private Integer id;
    private String name;
    private Brand brand;

    public Product(Integer id, String name, Brand brand) {
        this.id = id;
        this.name = name;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String display() {
        return "Id: " + this.id + "\t\t\t Produto: " + this.name + "\t\t\t Marca: " + this.brand.getName();
    }
}

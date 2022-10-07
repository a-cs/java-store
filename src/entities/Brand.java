package entities;

public class Brand {
    private Integer id;
    private String name;

    public Brand(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String display() {
        return "Id: " + this.id + "\t\t\t Marca: " + this.name;
    }
}

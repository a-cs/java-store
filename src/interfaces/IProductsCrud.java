package interfaces;

import entities.Brand;
import entities.Product;
import entities.Utils;

import java.util.List;

public interface IProductsCrud {
    public boolean create(String name, Brand brand);

    public List<String> showAll();

    public List<String> searchByName(String name);

    public List<String> searchByBrand(Brand brand);

    public Product searchProduct(String name, Brand brand);

    public boolean update(Product p, String newName, Brand newBrand);

    public boolean delete(String name, Brand brand);
}

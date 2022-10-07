package interfaces;

import entities.Brand;
import entities.Utils;

import java.util.List;

public interface IProductsCrud {
    public boolean create(String name, Brand brand);

    public List<String> showAll();

    public List<String> searchByName(String name);

    public List<String> searchByBrand(Brand brand);

    public boolean updateName(String oldName, String newName);

    public boolean delete(String name, Brand brand);
}

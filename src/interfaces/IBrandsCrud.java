package interfaces;

import entities.Brand;

import java.util.List;

public interface IBrandsCrud {
    public boolean create(String name);

    public List<String> showAll();

    public Brand find(String name);

    public boolean update(String oldName, String newName);

    public boolean delete(String name);
}

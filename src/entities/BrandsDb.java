package entities;

import interfaces.IBrandsCrud;

import java.util.ArrayList;
import java.util.List;

public class BrandsDb extends Utils implements IBrandsCrud {

    private List<Brand> list = new ArrayList<>();
    private Integer index = 0;

    @Override
    public boolean isUnique(String name) {
        for (Brand b : list) {
            if (b.getName().toUpperCase().equals(name.toUpperCase()))
                return false;
        }
        return true;
    }

    @Override
    public boolean create(String name) {
        if (Utils.isValid(name) && isUnique(name)) {
            list.add(new Brand(index++, name));
            return true;
        }
        return false;
    }

    @Override
    public List<String> showAll() {
        List<String> allBrands = new ArrayList<>();
        for (Brand b : list) {
            allBrands.add(b.display());
        }
        return allBrands;
    }

    @Override
    public Brand find(String name) {
        for (Brand b : list) {
            if (b.getName().equals(name))
                return b;
        }
        return null;
    }

    @Override
    public boolean update(String oldName, String newName) {
        if (Utils.isValid(oldName) && Utils.isValid(newName)) {
            for (Brand b : list) {
                if (b.getName().equals(oldName)) {
                    if (isUnique(newName)) {
                        b.setName(newName);
                        return true;
                    } else
                        return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean delete(String name) {
        if (Utils.isValid(name)) {
            for (Brand b : list) {
                if (b.getName().equals(name)) {
                    list.remove(b);
                    return true;
                }
            }
        }
        return false;
    }
}

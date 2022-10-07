package entities;

import interfaces.IBrandsCrud;

import java.util.ArrayList;
import java.util.List;

public class BrandsDb extends Utils implements IBrandsCrud {

    private List<Brand> brandsList = new ArrayList<>();
    private Integer index = 0;

    @Override
    public boolean isUnique(String name) {
        for (Brand b : brandsList) {
            if (b.getName().equalsIgnoreCase(name))
                return false;
        }
        return true;
    }

    @Override
    public boolean create(String name) {
        if (Utils.isValid(name) && isUnique(name)) {
            brandsList.add(new Brand(index++, name));
            return true;
        }
        return false;
    }

    @Override
    public List<String> showAll() {
        List<String> allBrands = new ArrayList<>();
        for (Brand b : brandsList) {
            allBrands.add(b.display());
        }
        return allBrands;
    }

    @Override
    public Brand find(String name) {
        for (Brand b : brandsList) {
            if (b.getName().equals(name))
                return b;
        }
        return null;
    }

    @Override
    public boolean update(String oldName, String newName) {
        if (Utils.isValid(oldName) && Utils.isValid(newName)) {
            for (Brand b : brandsList) {
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
            for (Brand b : brandsList) {
                if (b.getName().equals(name)) {
                    brandsList.remove(b);
                    return true;
                }
            }
        }
        return false;
    }
}

package entities;

import interfaces.IProductsCrud;

import java.util.ArrayList;
import java.util.List;

public class ProductsDb extends Utils implements IProductsCrud {

    private List<Product> list = new ArrayList<>();

    private Integer index = 0;

    @Override
    public boolean isUnique(String name, Brand brand) {
        for (Product p : list) {
            if (p.getName().toUpperCase().equals(name.toUpperCase()) && p.getBrand().equals(brand))
                return false;
        }
        return true;
    }

    @Override
    public boolean create(String name, Brand brand) {
        if (Utils.isValid(name) && isUnique(name, brand)) {
            list.add(new Product(index++, name, brand));
            return true;
        }
        return false;
    }


    @Override
    public List<String> showAll() {
        List<String> allProducts = new ArrayList<>();
        for (Product p : list) {
            allProducts.add(p.display());
        }
        return allProducts;
    }

    @Override
    public List<String> searchByName(String name) {
        List<String> products = new ArrayList<>();
        for (Product p : list) {
            if (p.getName().contains(name))
                products.add(p.display());
        }
        return products;
    }

    @Override
    public List<String> searchByBrand(Brand brand) {
        List<String> products = new ArrayList<>();
        for (Product p : list) {
            if (p.getBrand().equals(brand))
                products.add(p.display());
        }
        return products;
    }

    @Override
    public boolean updateName(String oldName, String newName) {
        return false;
    }

    @Override
    public boolean delete(String name, Brand brand) {
        if (Utils.isValid(name)) {
            for (Product p : list) {
                if (p.getName().equals(name) && p.getBrand().equals(brand)) {
                    list.remove(p);
                    return true;
                }
            }
        }
        return false;
    }
}

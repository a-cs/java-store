package entities;

import interfaces.IProductsCrud;

import java.util.ArrayList;
import java.util.List;

public class ProductsDb extends Utils implements IProductsCrud {

    private List<Product> productslist = new ArrayList<>();

    private Integer index = 0;

    @Override
    public boolean isUnique(String name, Brand brand) {
        for (Product p : productslist) {
            if (p.getName().equalsIgnoreCase(name) && p.getBrand().equals(brand))
                return false;
        }
        return true;
    }

    @Override
    public boolean create(String name, Brand brand) {
        if (Utils.isValid(name) && isUnique(name, brand)) {
            productslist.add(new Product(index++, name, brand));
            return true;
        }
        return false;
    }


    @Override
    public List<String> showAll() {
        List<String> allProducts = new ArrayList<>();
        for (Product p : productslist) {
            allProducts.add(p.display());
        }
        return allProducts;
    }

    @Override
    public Product searchProduct(String name, Brand brand) {
        if (Utils.isValid(name)) {
            for (Product p : productslist) {
                if (p.getName().equals(name) && p.getBrand().equals(brand))
                    return p;
            }
        }
        return null;
    }

    @Override
    public List<String> searchByName(String name) {
        List<String> products = new ArrayList<>();
        for (Product p : productslist) {
            if (p.getName().contains(name))
                products.add(p.display());
        }
        return products;
    }

    @Override
    public List<String> searchByBrand(Brand brand) {
        List<String> products = new ArrayList<>();
        for (Product p : productslist) {
            if (p.getBrand().equals(brand))
                products.add(p.display());
        }
        return products;
    }

    @Override
    public boolean update(Product p, String newName, Brand newBrand) {
        if (isUnique(newName, newBrand)) {
            p.setName(newName);
            p.setBrand(newBrand);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String name, Brand brand) {
        if (Utils.isValid(name)) {
            for (Product p : productslist) {
                if (p.getName().equals(name) && p.getBrand().equals(brand)) {
                    productslist.remove(p);
                    return true;
                }
            }
        }
        return false;
    }
}

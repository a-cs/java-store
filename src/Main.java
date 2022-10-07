import entities.*;

import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        BrandsDb brandsDb = new BrandsDb();
        ProductsDb productsDb = new ProductsDb();

        List menuList = Arrays.asList(0, 1, 2);
        int menu = 0;

        while (menuList.contains(menu)) {
            if (menu == 0)
                menu = MainMenu.use();
            if (menu == 1)
                menu = BrandMenu.use(brandsDb, productsDb);
            if (menu == 2)
                menu = ProductMenu.use(productsDb, brandsDb);

        }
    }
}
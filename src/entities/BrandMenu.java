package entities;

import javax.swing.*;
import java.util.List;

public class BrandMenu {
    public static int use(BrandsDb brandsDb, ProductsDb productsDb) {
        String option = JOptionPane.showInputDialog(null, "Escolha uma opção:\n1 - Criar Marca\n2 - Listar todas as Marcas\n3 - Alterar Marca\n4 - Excluir Marca\n9 - Voltar para o menu anterior\n0 - Sair", "Menu Marca", JOptionPane.QUESTION_MESSAGE);
        if (option == null)
            option = "9";
        switch (option) {
            case "1":
                BrandMenuOptions.create(brandsDb);
                break;
            case "2":
                BrandMenuOptions.showAll(brandsDb);
                break;
            case "3":
                BrandMenuOptions.update(brandsDb);
                break;
            case "4":
                BrandMenuOptions.delete(brandsDb, productsDb);
                break;
            case "9":
                return 0;
            case "0":
                System.exit(0);
            default:
                JOptionPane.showMessageDialog(null, "Opção invalida. Escolha uma opção valida.", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        return 1;
    }
}

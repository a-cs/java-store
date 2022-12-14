package entities;

import javax.swing.*;
import java.util.List;

public class ProductMenu {
    public static int use(ProductsDb productsDb, BrandsDb brandsDb) {
        String option = JOptionPane.showInputDialog(null, "Escolha uma opção:\n1 - Criar Produto\n2 - Listar todas os Produtos\n3 - Procurar Produtos\n4 - Alterar Produto\n5 - Excluir Produto\n9 - Voltar para o menu anterior\n0 - Sair", "Menu Marca", JOptionPane.QUESTION_MESSAGE);
        if (option == null)
            option = "9";
        switch (option) {
            case "1":
                ProductMenuOptions.create(productsDb, brandsDb);
                break;
            case "2":
                ProductMenuOptions.showAll(productsDb);
                break;
            case "3":
                ProductMenuOptions.searchByName(productsDb);
                break;
            case "4":
                ProductMenuOptions.update(productsDb, brandsDb);
                break;
            case "5":
                ProductMenuOptions.delete(productsDb, brandsDb);
                break;
            case "9":
                return 0;
            case "0":
                int flag = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja sair?", "Sair", JOptionPane.OK_CANCEL_OPTION);
                if (flag == 0)
                    System.exit(0);
                else
                    return 2;
            default:
                JOptionPane.showMessageDialog(null, "Opção invalida. Escolha uma opção valida.", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        return 2;
    }
}


package entities;

import javax.swing.*;
import java.util.List;

public class ProductMenuOptions {
    public static void create(ProductsDb productsDb, BrandsDb brandsDb){
        String inputBrandCreate = JOptionPane.showInputDialog("Digite o nome da marca:");
        if (Utils.isValid(inputBrandCreate)) {
            Brand brandCreate = brandsDb.find(inputBrandCreate);
            if (brandCreate != null) {
                String inputProduct = JOptionPane.showInputDialog("Digite o nome do produto:");
                if (productsDb.create(inputProduct, brandCreate))
                    JOptionPane.showMessageDialog(null, "O Produto " + inputProduct + " da Marca " + inputBrandCreate + " foi criado com sucesso.");
                else
                    JOptionPane.showMessageDialog(null, "Não foi possível criar o produto.", "Erro!", JOptionPane.ERROR_MESSAGE);
            } else
                JOptionPane.showMessageDialog(null, "A marca \"" + inputBrandCreate + "\" não foi encontrada no sistema.", "Erro!", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível criar o produto.", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void showAll(ProductsDb productsDb){
        List<String> listaRetorno = productsDb.showAll();
        if (listaRetorno.size() != 0) {
            System.out.println("Lista de todos os produtos:");
            System.out.println(String.join("\n", listaRetorno));
            System.out.println("");
            JOptionPane.showMessageDialog(null, "A lista foi impressa no console.");
        } else
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado.", "Erro!", JOptionPane.ERROR_MESSAGE);
    }

    public static void searchByName(ProductsDb productsDb){
        String inputSearch = JOptionPane.showInputDialog("Digite o nome completo ou parte do nome do produto:");
        if (Utils.isValid(inputSearch)) {
            List<String> listSearch = productsDb.searchByName(inputSearch);
            if (listSearch.size() != 0) {
                System.out.println("Lista de produtos encontrados contendo \"" + inputSearch + "\":");
                System.out.println(String.join("\n", listSearch));
                System.out.println("");
                JOptionPane.showMessageDialog(null, "A lista foi impressa no console.");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum produto encontrado.", "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void update(ProductsDb productsDb){
        String inputOldName = JOptionPane.showInputDialog("Digite o nome da marca que você deseja alterar:");
        String inputNewName = JOptionPane.showInputDialog("Digite o novo nome da marcar:");
        if (productsDb.updateName(inputOldName, inputNewName))
            JOptionPane.showMessageDialog(null, "A o nome da marcar \"" + inputOldName + "\" foi alterado para \"" + inputNewName + "\"");
        else
            JOptionPane.showMessageDialog(null, "Não foi possível alterar a marca.", "Erro!", JOptionPane.ERROR_MESSAGE);
    }

    public static void delete(ProductsDb productsDb, BrandsDb brandsDb){
        String inputBrandDelete = JOptionPane.showInputDialog("Digite o nome da marca do produto que deseja excluir:");
        if (Utils.isValid(inputBrandDelete)) {
            Brand brandDelete = brandsDb.find(inputBrandDelete);
            if (brandDelete != null) {
                String inputDelete = JOptionPane.showInputDialog("Digite o nome do produto para excluir:");
                if (productsDb.delete(inputDelete, brandDelete))
                    JOptionPane.showMessageDialog(null, "O produto \"" + inputDelete + "\" da marca \"" + inputBrandDelete + "\" foi excluido com sucesso");
                else
                    JOptionPane.showMessageDialog(null, "Erro ao excluir", "Erro!", JOptionPane.ERROR_MESSAGE);
            } else
                JOptionPane.showMessageDialog(null, "A marca \"" + inputBrandDelete + "\" não foi encontrada no sistema.", "Erro!", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar a marca.", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
}

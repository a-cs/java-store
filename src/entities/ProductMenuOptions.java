package entities;

import javax.swing.*;
import java.util.List;

public class ProductMenuOptions {
    public static void create(ProductsDb productsDb, BrandsDb brandsDb) {
        String inputBrand = JOptionPane.showInputDialog("Digite o nome da marca:");
        if (Utils.isValid(inputBrand)) {
            Brand brand = brandsDb.find(inputBrand);
            if (brand != null) {
                String inputProduct = JOptionPane.showInputDialog("Digite o nome do produto:");
                if (productsDb.create(inputProduct, brand))
                    JOptionPane.showMessageDialog(null, "O Produto " + inputProduct + " da Marca " + inputBrand + " foi criado com sucesso.");
                else
                    JOptionPane.showMessageDialog(null, "Não foi possível criar o produto.", "Erro!", JOptionPane.ERROR_MESSAGE);
            } else
                JOptionPane.showMessageDialog(null, "A marca \"" + inputBrand + "\" não foi encontrada no sistema.", "Erro!", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível criar o produto.", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void showAll(ProductsDb productsDb) {
        List<String> listaRetorno = productsDb.showAll();
        if (listaRetorno.size() != 0) {
            System.out.println("Lista de todos os produtos:");
            System.out.println(String.join("\n", listaRetorno));
            System.out.println("");
            JOptionPane.showMessageDialog(null, "A lista foi impressa no console.");
        } else
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado.", "Erro!", JOptionPane.ERROR_MESSAGE);
    }

    public static void searchByName(ProductsDb productsDb) {
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

    public static void update(ProductsDb productsDb, BrandsDb brandsDb) {
        String inputOldBrand = JOptionPane.showInputDialog("Digite a marca do produto que você deseja alterar:");
        if (Utils.isValid(inputOldBrand)) {
            Brand oldBrand = brandsDb.find(inputOldBrand);
            if (oldBrand != null) {
                String inputOldName = JOptionPane.showInputDialog("Digite o nome do produto que você deseja alterar:");
                Product p = productsDb.searchProduct(inputOldName, oldBrand);
                if (p != null) {
                    String inputNewBrand = JOptionPane.showInputDialog("Produto a alterar:\n" + p.display() + "\nDigite a nova marca do produto:");
                    if (Utils.isValid(inputNewBrand)) {
                        Brand newBrand = brandsDb.find(inputNewBrand);
                        if (newBrand != null) {
                            String inputNewName = JOptionPane.showInputDialog("Produto a alterar:\n" + p.display() + "\nDigite o novo nome do produto:");
                            if (productsDb.update(p, inputNewName, newBrand))
                                JOptionPane.showMessageDialog(null, "O Produto foi alterado com sucesso.");
                            else
                                JOptionPane.showMessageDialog(null, "Não foi possível alterar o produto.", "Erro!", JOptionPane.ERROR_MESSAGE);
                        } else
                            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar a marca no sistema.", "Erro!", JOptionPane.ERROR_MESSAGE);
                    } else
                        JOptionPane.showMessageDialog(null, "Não foi possivel encontrar a marca no sistema.", "Erro!", JOptionPane.ERROR_MESSAGE);
                } else
                    JOptionPane.showMessageDialog(null, "Não foi possivel encontrar o produto no sistema.", "Erro!", JOptionPane.ERROR_MESSAGE);
            } else
                JOptionPane.showMessageDialog(null, "Não foi possivel encontrar a marca no sistema.", "Erro!", JOptionPane.ERROR_MESSAGE);
        } else
            JOptionPane.showMessageDialog(null, "Não foi possivel encontrar a marca no sistema.", "Erro!", JOptionPane.ERROR_MESSAGE);
    }

    public static void delete(ProductsDb productsDb, BrandsDb brandsDb) {
        String inputBrandDelete = JOptionPane.showInputDialog("Digite o nome da marca do produto que deseja excluir:");
        if (Utils.isValid(inputBrandDelete)) {
            Brand brandDelete = brandsDb.find(inputBrandDelete);
            if (brandDelete != null) {
                String inputDelete = JOptionPane.showInputDialog("Digite o nome do produto para excluir:");
                int flag = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir o produto \"" + inputDelete + "\" da marca \"" + inputBrandDelete + "\"?", "Excluir", JOptionPane.OK_CANCEL_OPTION);
                if (flag == 0) {
                    if (productsDb.delete(inputDelete, brandDelete))
                        JOptionPane.showMessageDialog(null, "O produto \"" + inputDelete + "\" da marca \"" + inputBrandDelete + "\" foi excluido com sucesso");
                    else
                        JOptionPane.showMessageDialog(null, "Erro ao excluir", "Erro!", JOptionPane.ERROR_MESSAGE);
                }
            } else
                JOptionPane.showMessageDialog(null, "A marca \"" + inputBrandDelete + "\" não foi encontrada no sistema.", "Erro!", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar a marca.", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
}

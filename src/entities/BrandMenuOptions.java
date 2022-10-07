package entities;

import javax.swing.*;
import java.util.List;

public class BrandMenuOptions {
    public static void create(BrandsDb brandsDb){
        String input = JOptionPane.showInputDialog("Digite o nome da nova marcar:");
        if (brandsDb.create(input))
            JOptionPane.showMessageDialog(null, "A marca " + input + " foi criada com sucesso.");
        else
            JOptionPane.showMessageDialog(null, "Não foi possível criar a marca.", "Erro!", JOptionPane.ERROR_MESSAGE);
    }

    public static void showAll(BrandsDb brandsDb){
        List<String> listaRetorno = brandsDb.showAll();
        if (listaRetorno.size() != 0) {
            System.out.println("Lista de todas as marcas:");
            System.out.println(String.join("\n", listaRetorno));
            System.out.println("");
            JOptionPane.showMessageDialog(null, "A lista foi impressa no console.");
        } else
            JOptionPane.showMessageDialog(null, "Nenhuma marca cadastrada.", "Erro!", JOptionPane.ERROR_MESSAGE);
    }

    public static void update(BrandsDb brandsDb){
        String inputOldName = JOptionPane.showInputDialog("Digite o nome da marca que você deseja alterar:");
        String inputNewName = JOptionPane.showInputDialog("Digite o novo nome da marcar:");
        if (brandsDb.update(inputOldName, inputNewName))
            JOptionPane.showMessageDialog(null, "A o nome da marcar \"" + inputOldName + "\" foi alterado para \"" + inputNewName + "\"");
        else
            JOptionPane.showMessageDialog(null, "Não foi possível alterar a marca.", "Erro!", JOptionPane.ERROR_MESSAGE);
    }

    public static void delete(BrandsDb brandsDb, ProductsDb productsDb){
        String inputDelete = JOptionPane.showInputDialog("Digite o nome da marca que deseja excluir:");
        if (Utils.isValid(inputDelete)) {
            Brand brandDelete = brandsDb.find(inputDelete);
            if (brandDelete != null) {
                List<String> productsList = productsDb.searchByBrand(brandDelete);
                if (productsList.size() == 0) {

                    if (brandsDb.delete(inputDelete))
                        JOptionPane.showMessageDialog(null, inputDelete + " foi excluido com sucesso");
                    else
                        JOptionPane.showMessageDialog(null, "Erro ao excluir", "Erro!", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Não é possivel excluir marcas com produtos cadastrados.", "Erro!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível encontrar a marca.", "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar a marca.", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }
}

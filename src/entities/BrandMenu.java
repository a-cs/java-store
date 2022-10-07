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
                String input = JOptionPane.showInputDialog("Digite o nome da nova marcar:");
                if (brandsDb.create(input))
                    JOptionPane.showMessageDialog(null, "A marca " + input + " foi criada com sucesso.");
                else
                    JOptionPane.showMessageDialog(null, "Não foi possível criar a marca.", "Erro!", JOptionPane.ERROR_MESSAGE);
                break;
            case "2":
                List<String> listaRetorno = brandsDb.showAll();
                if (listaRetorno.size() != 0) {
                    System.out.println("Lista de todas as marcas:");
                    System.out.println(String.join("\n", listaRetorno));
                    System.out.println("");
                    JOptionPane.showMessageDialog(null, "A lista foi impressa no console.");
                } else
                    JOptionPane.showMessageDialog(null, "Nenhuma marca cadastrada.", "Erro!", JOptionPane.ERROR_MESSAGE);
                break;
            case "3":
                String inputOldName = JOptionPane.showInputDialog("Digite o nome da marca que você deseja alterar:");
                String inputNewName = JOptionPane.showInputDialog("Digite o novo nome da marcar:");
                if (brandsDb.update(inputOldName, inputNewName))
                    JOptionPane.showMessageDialog(null, "A o nome da marcar \"" + inputOldName + "\" foi alterado para \"" + inputNewName + "\"");
                else
                    JOptionPane.showMessageDialog(null, "Não foi possível alterar a marca.", "Erro!", JOptionPane.ERROR_MESSAGE);
                break;
            case "4":
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

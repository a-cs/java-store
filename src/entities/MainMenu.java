package entities;

import javax.swing.*;
import java.util.List;

public class MainMenu {
    public static int use() {
        String option = JOptionPane.showInputDialog(null, "Escolha uma opção:\n1 - Menu Marcas\n2 - Menu Produtos\n0 - Sair", "Menu Inicial", JOptionPane.QUESTION_MESSAGE);
        if (option == null)
            option = "0";
        switch (option) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "9":
                return 0;
            case "0":
                System.exit(0);
            default:
                JOptionPane.showMessageDialog(null, "Opção invalida. Escolha uma opção valida.", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        return 0;
    }
}

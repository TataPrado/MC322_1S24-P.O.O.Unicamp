package Lab5;

import java.util.List;

public class MasmorraView {
    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayItensDisponiveis(List<Item> itensDisponiveis) {
        if (itensDisponiveis == null || itensDisponiveis.isEmpty()) {
            System.out.println("O baú está vazio. Não há itens disponíveis para escolha.");
        } else {
            for (int i = 0; i < itensDisponiveis.size(); i++) {
                System.out.println((i + 1) + ". " + itensDisponiveis.get(i).getNomeItem() + " - nível " + itensDisponiveis.get(i).getBonusPoder());
            }
        }
    }

    public void displayResultadoBatalha(Resultado resultado) {
        System.out.println("Resultado da batalha: " + resultado);
    }
}

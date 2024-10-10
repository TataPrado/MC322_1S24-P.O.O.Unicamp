package Lab5;

import InterfaceLab5.Jogo;
import java.util.List;
import java.util.Scanner;

public class MasmorraController {
    private Masmorra model;
    private MasmorraView view;
    private Masmorra masmorra;

    public MasmorraController(Masmorra model, MasmorraView view) {
        this.model = model;
        this.view = view;
        this.masmorra = model;
    }

    public MasmorraController(){}

    public void abrirPortaMonstro(Jogador jogador) {
        view.displayMessage("Uma porta do Monstro se abre!");

        Monstro monstro = model.obterMonstroAleatorio();
        if (monstro == null) {
            view.displayMessage("Não há monstros disponíveis na masmorra.");
            return;
        }

        Inventario inventario = jogador.getInventario();
        List<Item> itens = inventario.getItens();

        Resultado resultadoBatalha = CampoDeBatalha.batalharContraMonstro(monstro, jogador, itens);
        view.displayResultadoBatalha(resultadoBatalha);
    }

    public Item abrirPortaItem(Jogador jogador, Jogo jogo) {
        view.displayMessage("Uma porta de Item se abre!");

        List<Item> itensDisponiveis = model.obterItensDisponiveis(jogo);
        view.displayItensDisponiveis(itensDisponiveis);

        if (itensDisponiveis != null && !itensDisponiveis.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            int escolha;
            do {
                view.displayMessage("Escolha o número do item que deseja: ");
                while (!scanner.hasNextInt()) {
                    view.displayMessage("Por favor, insira um número válido.");
                    scanner.next(); // Clear the invalid input
                }
                escolha = scanner.nextInt();
            } while (escolha < 1 || escolha > itensDisponiveis.size());

            Item itemEscolhido = itensDisponiveis.get(escolha - 1);

            if (jogador.getInventario().adicionarItem(itemEscolhido)) {
                view.displayMessage("Você obteve o item: " + itemEscolhido.getNomeItem());
                model.removerItemDoJogo(jogo, itemEscolhido);
            } else {
                view.displayMessage("Não foi possível adicionar o item ao inventário.");
            }
        }
        return null;
    }
    
    public void adicionarMonstro(Monstro monstro) {
        this.masmorra.getMonstros().add(monstro);
    }
}

package Lab3;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Masmorra {
    //Attributes
    protected BauDeTesouros tesouros;
    private List<Monstro> monstros;

    //Methods
    public Masmorra(BauDeTesouros tesouros, List<Monstro> monstros){
        this.tesouros = tesouros;
        this.monstros = monstros;
    }

    public void abrirPortaMonstro (Jogador jogador){
        System.out.println("Uma porta do Monstro se abre!");

        // Verificar se há monstros disponíveis na lista
        if (monstros.isEmpty()) {
            System.out.println("Não há monstros disponíveis na masmorra.");
            return;
        }

        // Escolher um monstro aleatório da lista de monstros
        Random random = new Random();
        int indiceAleatorio = random.nextInt(monstros.size());
        Monstro monstro = monstros.get(indiceAleatorio);

        // Realizar a batalha entre o jogador e o monstro
        Inventario inventario = jogador.getInventario();
        List<Item> itens = inventario.getItens();

        // Iniciar a batalha entre o jogador e o monstro
        Resultado resultadoBatalha = CampoDeBatalha.batalharContraMonstro(monstro, jogador, itens);
    }


    public void abrirPortaItem(Jogador jogador) {
        System.out.println("Uma porta de Item se abre!");

        // Verificar se há itens disponíveis no baú
        List<Item> itensDisponiveis = tesouros.listarItens();
        if (itensDisponiveis == null || itensDisponiveis.isEmpty()) {
            System.out.println("O baú está vazio. Não há itens disponíveis para escolha.");
            return;
        }

        // Imprimir dois itens aleatórios para o jogador escolher um
        System.out.println("Escolha um dos seguintes itens:");
        for (int i = 0; i < itensDisponiveis.size(); i++) {
            System.out.println((i + 1) + ". " + itensDisponiveis.get(i));
        }

        // Ler a escolha do jogador
        Scanner scanner = new Scanner(System.in);
        int escolha;
        do {
            System.out.print("Escolha o número do item que deseja: ");
            escolha = scanner.nextInt();
        } while (escolha < 1 || escolha > itensDisponiveis.size());

        // Acessar o item escolhido no baú de tesouros e atribuir ao inventário do jogador
        Lab3.Item itemEscolhido = tesouros.acessarItem(itensDisponiveis.get(escolha - 1).getNomeItem());
        if (itemEscolhido != null) {
            jogador.getInventario().adicionarItem(itemEscolhido);
            System.out.println("Você obteve o item: " + itemEscolhido);
        }
        else {
            System.out.println("Falha ao obter o item escolhido.");
        }
        
    }
}

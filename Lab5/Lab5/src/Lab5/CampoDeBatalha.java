package Lab5;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CampoDeBatalha {
    private Jogador jogador;
    private Monstro monstro;

    //Method
    public static Resultado batalharContraMonstro(Monstro monstro, Jogador jogador, List<Item> itens){
        int valorJog = jogador.poderJogador();
        int valorMonst = monstro.getPoder();

        if (valorJog > valorMonst){
            System.out.println("Você venceu o monstro!");
            int quantidade = monstro.getTesouros();

            BauDeTesouros bau = new BauDeTesouros(quantidade, itens);
            List<Item> tesouros = bau.pegarItensAleatorios(quantidade);
            for (Item item : tesouros) {
                jogador.getInventario().adicionarItem(item);
            }
            System.out.println("Você adquiriu os seguintes tesouros: " + tesouros);
        }
        else if (valorJog < valorMonst) {
            System.out.println("O monstro é mais poderoso! Você tentará fugir...");
            if (tentarFugir()) {
                System.out.println("Você conseguiu fugir!");
            }
            else {
                int niveisPerdidos = monstro.getNivel();
                int nivel = jogador.getNivel() - niveisPerdidos ;
                System.out.println("Você não conseguiu fugir! Perdeu " + niveisPerdidos + " nível(eis).");
                System.out.println("Seu nivel atual é: " + nivel);
            }
        }
        else {
            System.out.println("É um empate! Você pode decidir fugir ou lutar.");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite 1 para tentar fugir ou 2 para lutar:");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    if (tentarFugir()) {
                        System.out.println("Você conseguiu fugir!");
                    } else {
                        System.out.println("Você não conseguiu fugir!");
                        int niveisPerdidos = monstro.getNivel();
                        int nivel = jogador.getNivel() - niveisPerdidos;
                        System.out.println("Perdeu " + niveisPerdidos + " nível(eis).");
                        System.out.println("Seu nível atual é: " + nivel);
                    }
                    break;
                case 2:
                    System.out.println("Você escolheu lutar.");
                    // Implement your fight logic here
                    break;
                default:
                    System.out.println("Escolha inválida. Você não conseguiu decidir.");
                    break;
            }
        }
        return null;
    }

    private static boolean tentarFugir() {
        Random random = new Random();
        int dado = random.nextInt(6) + 1; // Lança o dado
        return dado == 5 || dado == 6; // Retorna verdadeiro se tirar 5 ou 6
    }
}

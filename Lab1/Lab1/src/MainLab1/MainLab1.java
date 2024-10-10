package MainLab1;

import Lab1.*;

public class MainLab1 {
    public static void main(String[] args){
        Jogador jogador = new Jogador("Humano", 0, null, null, null, null, "", "", null);
        Monstro monstro = new Monstro ("Dragão de Plutônio", 0, 0, 0);
        Item item = new Item ("Poção da Invisibilidade", 0, 0, null);

        System.out.println(jogador.toString());
        System.out.println(monstro.toString());
        System.out.println(item.toString());
        System.out.println(jogador.possuiMaoVazia());
    }
}

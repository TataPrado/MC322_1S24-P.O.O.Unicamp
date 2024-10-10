package InterfaceLab5;

import Lab5.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();

        LerItens lerItens = new LerItens();
        List<Item> itens = lerItens.lerArquivo(jogo, "C:\\JMC17\\laboratorio-5-TataPrado\\Lab5\\src\\InterfaceLab5\\Itens.xml");

        LerMonstros lerMonstros = new LerMonstros();
        List<Monstro> monstros = lerMonstros.lerArquivo(jogo, "C:\\JMC17\\laboratorio-5-TataPrado\\Lab5\\src\\InterfaceLab5\\Monstros.xml");

        LerJogadores lerJogadores = new LerJogadores();
        List<Jogador> jogadores = lerJogadores.lerArquivo(jogo, "C:\\JMC17\\laboratorio-5-TataPrado\\Lab5\\src\\InterfaceLab5\\Jogadores.xml");

        // Iniciar o jogo
        jogo.iniciarJogo();
    }
}

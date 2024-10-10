package InterfaceLab4;

import Lab4.Item;
import Lab4.Jogador;
import Lab4.Monstro;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Jogo jogo = new Jogo();

        LerItens lerItens = new LerItens();
        List<Item> itens = lerItens.lerArquivo(jogo, "C:\\JMC17\\laboratorio-4-TataPrado\\Lab4\\src\\InterfaceLab4\\Itens.xml");
        jogo.getInventario().setItens(itens);

        LerMonstros lerMonstros = new LerMonstros();
        List<Monstro> monstros = lerMonstros.lerArquivo(jogo, "C:\\JMC17\\laboratorio-4-TataPrado\\Lab4\\src\\InterfaceLab4\\Monstros.xml");
        jogo.setMasmorra(monstros);

        LerJogadores lerJogadores = new LerJogadores();
        List<Jogador> jogadores = lerJogadores.lerArquivo(jogo, "C:\\JMC17\\laboratorio-4-TataPrado\\Lab4\\src\\InterfaceLab4\\Jogadores.xml");
        jogo.setJogadores(jogadores);

        // Iniciar o jogo
        jogo.iniciarJogo();
    }
}

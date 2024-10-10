package InterfaceLab5;

import Lab5.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LerJogadores implements I_Arquivo<Jogador> {
    @Override
    public List<Jogador> lerArquivo(Jogo jogo, String path) {
        List<Jogador> jogadores = new ArrayList<>();

        try {
            File file = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Jogador");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element jogadorElement = (Element) nodeList.item(i);

                String nome = jogadorElement.getElementsByTagName("nome").item(0).getTextContent();
                int nivel = Integer.parseInt(jogadorElement.getElementsByTagName("nivel").item(0).getTextContent());
                Raca.Racas raca = Raca.Racas.valueOf(jogadorElement.getElementsByTagName("raca").item(0).getTextContent());
                Classe.Classes classe = Classe.Classes.valueOf(jogadorElement.getElementsByTagName("classe").item(0).getTextContent());

                Jogador jogador = new Jogador(nome, nivel, raca, classe, new Inventario(), null, null, null, null, null);
                jogadores.add(jogador);
            }
        } catch (Exception e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            e.printStackTrace();
        }

        jogo.setJogadores(jogadores);
        return jogadores;
    }
}

package InterfaceLab4;

import Lab4.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LerItens implements I_Arquivo<Item> {
    public List<Item> lerArquivo(Jogo jogo, String path) {
        List<Item> itens = new ArrayList<>();

        try {
            File file = new File(path);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Item");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element itemElement = (Element) nodeList.item(i);

                String nomeItem = itemElement.getElementsByTagName("nome").item(0).getTextContent();
                int bonusPoder = Integer.parseInt(itemElement.getElementsByTagName("bonusPoder").item(0).getTextContent());
                int valor = Integer.parseInt(itemElement.getElementsByTagName("valor").item(0).getTextContent());
                TipoItem.TiposItens tipo = TipoItem.TiposItens.valueOf(itemElement.getElementsByTagName("tipo").item(0).getTextContent());
                boolean itemGrande = Boolean.parseBoolean(itemElement.getElementsByTagName("itemGrande").item(0).getTextContent());

                NodeList classesCompativeisNodeList = itemElement.getElementsByTagName("classesCompativeis").item(0).getChildNodes();
                List<Classe.Classes> classesCompativeis = new ArrayList<>();
                for (int j = 0; j < classesCompativeisNodeList.getLength(); j++) {
                    if (classesCompativeisNodeList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element classeElement = (Element) classesCompativeisNodeList.item(j);
                        Classe.Classes classe = Classe.Classes.valueOf(classeElement.getTextContent());
                        classesCompativeis.add(classe);
                    }
                }

                NodeList racasCompativeisNodeList = itemElement.getElementsByTagName("racasCompativeis").item(0).getChildNodes();
                List<Raca.Racas> racasCompativeis = new ArrayList<>();
                for (int j = 0; j < racasCompativeisNodeList.getLength(); j++) {
                    if (racasCompativeisNodeList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element racaElement = (Element) racasCompativeisNodeList.item(j);
                        Raca.Racas raca = Raca.Racas.valueOf(racaElement.getTextContent());
                        racasCompativeis.add(raca);
                    }
                }

                Item item = new Item(nomeItem, bonusPoder, valor, tipo, itemGrande, classesCompativeis, racasCompativeis);
                itens.add(item);
            }
            jogo.setInventario(itens);
        } catch (Exception e) {
            System.err.println("Erro ao ler o arquivo de itens: " + e.getMessage());
            e.printStackTrace();
        }
        return itens;
    }
}


package Lab5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class BauDeTesouros extends Inventario {
    //Attributes
    private static BauDeTesouros instancia;

    //Methods
    private BauDeTesouros() {}

    public static BauDeTesouros getInstance(){
        if (instancia == null){
            instancia = new BauDeTesouros();
        }
        return instancia;
    }

    public BauDeTesouros(int limiteDeltens, List<Item> itens) {
        super(limiteDeltens, itens);
    }

    public Item acessarItem(String nomeItem) {
        Iterator<Item> iterator = itens.iterator(); // Iterar sobre os itens
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getNomeItem().equals(nomeItem)) { // Verificar se o nome do item corresponde ao fornecido
                iterator.remove(); // Se o item for encontrado, removê-lo do inventário e retorná-lo
                System.out.println("Item: " + nomeItem + " foi removido do Baú de Tesouros");
                return item; // Retornar o item encontrado e removido
            }
        }
        System.out.println ("Não há essa carta de item no inventário");
        return null;
    }

    public List<Item> listarItens(List<Item> itens){
        System.out.println("Tamanho do inventário: " + itens.size());

        if (itens.isEmpty()) { // Verificar se a lista de itens está vazia
            System.out.println("O inventário está vazio.");
            return new ArrayList<>(); // Retorna uma lista vazia
        }

        Random random = new Random(); // Criar um objeto Random para gerar números aleatórios

        if (itens.size() == 1) {
            // Se a lista contiver apenas um item, retorna essa lista com um único item
            return new ArrayList<>(itens);
        }

        int index1 = random.nextInt(itens.size()); // Gerar o primeiro índice aleatório
        int index2;
        do {
            index2 = random.nextInt(itens.size()); // Gerar o segundo índice aleatório
        } while (index2 == index1); // Garantir que os índices não sejam iguais

        // Obter os itens correspondentes aos índices gerados
        Item item1 = itens.get(index1);
        Item item2 = itens.get(index2);

        // Criar uma lista para armazenar os dois itens
        List<Item> itensSelecionados = new ArrayList<>();
        itensSelecionados.add(item1);
        itensSelecionados.add(item2);

        return itensSelecionados;
    }

    public List<Item> pegarItensAleatorios(int quantidade){
        if (itens.isEmpty()) { // Verificar se a lista de itens está vazia
            System.out.println("O inventário está vazio.");
            return null;
        }

        Random random = new Random(); // Criar um objeto Random para gerar números aleatórios

        List<Item> itensSelecionados = new ArrayList<>();
        int n = 0;
        while (n < quantidade) {
            int index = random.nextInt(itens.size());
            Item item = itens.get(index);
            if (!itensSelecionados.contains(item)) { // Verificar se o item já foi selecionado
                itensSelecionados.add(item);
                n++;
            }
        }
        // Remover os itens selecionados do baú de tesouros
        for (Item item : itensSelecionados) {
            itens.remove(item);
        }

        System.out.println("Baú de Tesouros: " + itensSelecionados);
        return itensSelecionados;
    }

}


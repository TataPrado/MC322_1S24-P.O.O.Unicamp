package Lab4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class BauDeTesouros extends Inventario {

    //Methods
    public BauDeTesouros(int limiteDeltens, List<Item> itens) {
        super(limiteDeltens, itens);
    }

    public BauDeTesouros() {
        super();
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

    public List<Item> listarItens(){
        if (itens.isEmpty()) { // Verificar se a lista de itens está vazia
            System.out.println("O inventário está vazio.");
            return null;
        }
        
        Random random = new Random();// Criar um objeto Random para gerar números aleatórios

        int index1 = random.nextInt(itens.size()); // Gerar dois índices aleatórios dentro do intervalo válido da lista de itens
        int index2 = random.nextInt(itens.size());
        while (index2 == index1){ // Garantir que os índices não sejam iguais
            index2 = random.nextInt(itens.size());
        }

        // Obter os itens correspondentes aos índices gerados
        Item item1 = itens.get(index1);
        Item item2 = itens.get(index2);

        // Criar uma para armazenar os dois itens
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

